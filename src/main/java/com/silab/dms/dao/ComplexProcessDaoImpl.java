package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.ComplexProcess;

@Repository("complexProcessDao")
public class ComplexProcessDaoImpl extends AbstractDao<Integer, CompanyDao> implements ComplexProcessDao {

	@Override
	public List<ComplexProcess> retrieveComplexProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<ComplexProcess>)criteria.list();
	}

}
