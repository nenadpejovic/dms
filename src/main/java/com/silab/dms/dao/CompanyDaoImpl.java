package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.Company;
import com.silab.dms.model.User;

@Repository("companyDao")
public class CompanyDaoImpl extends AbstractDao<Integer, Company> implements CompanyDao{

	@Override
	public List<Company> retrieveAllCompanies() {
		Criteria criteria = createEntityCriteria();
		return (List<Company>)criteria.list();
	}

	@Override
	public void save(Company company) {
		persist(company);
	}

}
