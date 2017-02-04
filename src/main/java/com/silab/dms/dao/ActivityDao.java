package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.Activity;

public interface ActivityDao {
	
	public List<Activity> retrieveAllActivities();
}
