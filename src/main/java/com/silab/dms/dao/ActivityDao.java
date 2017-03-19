package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.Activity;
import com.silab.dms.model.PrimitiveProcess;

public interface ActivityDao {
	
	public List<Activity> retrieveAllActivities();
	public List<Activity> retrieveActivitiesByProcess(long processId);
	public void save(Activity activity);
	public void delete(Activity activity);
}
