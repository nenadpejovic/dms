package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.ordering.antlr.GeneratedOrderByFragmentRendererTokenTypes;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Activity;
import com.silab.dms.model.PrimitiveProcess;

@Repository("activityDao")
public class ActivityDaoImpl extends AbstractDao<Integer , Activity> implements ActivityDao{

	@Override
	public List<Activity> retrieveAllActivities() {
		Criteria criteria = createEntityCriteria();
		return (List<Activity>)criteria.list();
	}

	@Override
	public List<Activity> retrieveActivitiesByProcess(long processId) {
		Criteria criteria = createEntityCriteria().createAlias("process", "p");
		criteria.add(Restrictions.eq("p.processId", processId));
		return criteria.list();
	}

	@Override
	public void save(Activity activity) {
		persist(activity);
	}
	
	@Override
	public void delete(Activity activity) {
        Query query = getSession().createQuery("delete Activity where activityId = :activityId");
        query.setParameter("activityId", activity.getActivityId());
        query.executeUpdate();
	}


}
