package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.Company;

public interface CompanyDao{
	
	public List<Company> retrieveAllCompanies();

    void save(Company company);
}
