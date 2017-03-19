package com.silab.dms.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.silab.dms.controllers.dto.ActivityInfo;
import com.silab.dms.model.Activity;
import com.silab.dms.model.Document;
import com.silab.dms.service.ActivityService;

@CrossOrigin
@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Autowired
	ActivityService activityService;
	
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public  void save(@RequestBody ActivityInfo activityInfo, HttpServletRequest request) {
    	Activity activity = new Activity(activityInfo.getProcess(), activityInfo.getActivityName(), activityInfo.getInputDocument(), activityInfo.getOutputDocument());
        activityService.save(activity);
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public  void delete(@RequestBody Activity activity) {
        activityService.delete(activity);
    }
}
