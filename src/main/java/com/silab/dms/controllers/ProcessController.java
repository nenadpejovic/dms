package com.silab.dms.controllers;

import com.silab.dms.dao.PrimitiveProcessDao;
import com.silab.dms.model.Activity;
import com.silab.dms.model.ComplexProcess;
import com.silab.dms.model.PrimitiveProcess;
import com.silab.dms.model.Process;
import com.silab.dms.service.ActivityService;
import com.silab.dms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by msav on 2/18/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @Autowired
    ActivityService activityService;

    @RequestMapping(value = "/{vat}", method = RequestMethod.GET)
    public @ResponseBody List<Process> getProcesses(@PathVariable long vat) {

        List<Process> processes = processService.getProcessesByCompany(vat);
        
        return processes;
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteProcess(@RequestBody Process process) {

        processService.deleteProcess(process);
    }
    
    @RequestMapping(value = "/complex/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void saveComplexProcess(@RequestBody ComplexProcess process) {
        updateParentProcess(process);
    	processService.save(process);
    }
    
    @RequestMapping(value = "/primitive/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void savePrimitiveProcess(@RequestBody PrimitiveProcess process) {
        updateParentProcess(process);
        processService.save(process);
    }

    private void updateParentProcess(@RequestBody Process process) {
        if(process.getParentProcess() != null) {
            ComplexProcess parentProcess = (ComplexProcess) process.getParentProcess();
            if(parentProcess.getChildProcesses() == null) {
                parentProcess.setChildProcesses(new LinkedList<>());
            }
            parentProcess.getChildProcesses().add(process);

            processService.update(parentProcess);
        }
    }
}
