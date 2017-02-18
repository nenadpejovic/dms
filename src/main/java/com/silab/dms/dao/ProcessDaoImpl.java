package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Process;

@Repository("processDao")
public class ProcessDaoImpl extends AbstractDao<Integer, Process> implements ProcessDao{
	
	@Override
	public List<Process> retrieveAllProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<Process>)criteria.list();
	}

	@Override
	public List<Process> retreiveProcessesByCompany(long vat) {
		Criteria criteria = getSession().createCriteria(Process.class, "process")
				.createAlias("company", "c");

		criteria.add(Restrictions.eq("c.vat", vat));

		return criteria.list();
	}

}
