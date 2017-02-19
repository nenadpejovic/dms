package com.silab.dms.controllers;

import com.silab.dms.model.Process;
import com.silab.dms.service.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by msav on 2/18/2017.
 */
@CrossOrigin
@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    ProcessService processService;

    @RequestMapping(value = "/{vat}", method = RequestMethod.GET)
    public @ResponseBody List<Process> getProcesses(@PathVariable long vat) {

        return processService.getProcessesByCompany(vat);
    }
}
