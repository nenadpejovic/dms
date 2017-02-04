package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Process;

@Repository("processDao")
public class ProcessDaoImpl extends AbstractDao<Integer, Process> implements ProcessDao{
	
	@Override
	public List<Process> retrieveAllProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<Process>)criteria.list();
	}

}
