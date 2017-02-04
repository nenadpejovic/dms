package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.ActivityDao;
import com.silab.dms.model.Activity;

@Service("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityDao activityDao;
	
	@Override
	public List<Activity> retrieveAllActivities() {
		return activityDao.retrieveAllActivities();
	}

}
