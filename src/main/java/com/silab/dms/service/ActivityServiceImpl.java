package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.ActivityDao;
import com.silab.dms.model.Activity;
import com.silab.dms.model.PrimitiveProcess;

@Service("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	ActivityDao activityDao;
	
	@Override
	public List<Activity> retrieveAllActivities() {
		return activityDao.retrieveAllActivities();
	}

	@Override
	public List<Activity> retrieveActivitiesByProcess(long processId) {
		// TODO Auto-generated method stub
		return activityDao.retrieveActivitiesByProcess(processId);
	}

	@Override
	public void save(Activity activity) {
		activityDao.save(activity);
		
	}
	
	@Override
	public void delete(Activity activity) {
		activityDao.delete(activity);
		
	}


}
