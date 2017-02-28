package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.CompanyDao;
import com.silab.dms.model.Company;
import com.silab.dms.model.User;

@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	CompanyDao companyDao;
	
	@Override
	public List<Company> retrieveAllCompanies() {
		return companyDao.retrieveAllCompanies();
	}

	@Override
	public Company save(Company company) {
		return companyDao.save(company);
	}



}
