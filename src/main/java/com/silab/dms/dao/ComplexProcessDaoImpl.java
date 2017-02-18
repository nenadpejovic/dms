package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Company;
import com.silab.dms.model.ComplexProcess;
import com.silab.dms.model.PrimitiveProcess;

@Repository("complexProcessDao")
public class ComplexProcessDaoImpl extends AbstractDao<Integer, CompanyDao> implements ComplexProcessDao {

	@Override
	public List<ComplexProcess> retrieveComplexProcesses() {
		Criteria criteria = createEntityCriteria();
		return (List<ComplexProcess>)criteria.list();
	}

	@Override
	public List<ComplexProcess> retrieveComplexProcessesByCompany(Company company) {

		Query query = getSession().createQuery("from Company where companyId = :companyId");
		query.setParameter("companyId", company.getCompanyId());
		List<ComplexProcess> complexProccesses = query.list();
		return complexProccesses;
	}
}
