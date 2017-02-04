package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Activity;

@Repository("activityDao")
public class ActivityDaoImpl extends AbstractDao<Integer , Activity> implements ActivityDao{

	@Override
	public List<Activity> retrieveAllActivities() {
		Criteria criteria = createEntityCriteria();
		return (List<Activity>)criteria.list();
	}

}
