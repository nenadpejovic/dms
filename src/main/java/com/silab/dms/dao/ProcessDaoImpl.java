package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.*;
import com.silab.dms.model.Process;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("processDao")
public class ProcessDaoImpl extends AbstractDao<Integer, Process> implements ProcessDao{
	@Autowired
	CompanyDao companyDao;

	@Override
	public List<Process> retrieveAllProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<Process>)criteria.list();
	}

	@Override
	public List<Process> retreiveProcessesByCompany(long vat) {
		Criteria criteria = createEntityCriteria()
				.createAlias("company", "c");

		criteria.add(Restrictions.eq("c.vat", vat));

		return criteria.list();
		
	}

	@Override
	public void save(Process process) {
		// TODO Auto-generated method stub
	    persist(process);
	}

	@Override
	public void deleteProcess(Process process) {
		delete(process);
	}

	@Override
	public void update(ComplexProcess parentProcess) {
		getSession().update(parentProcess);
	}


}
