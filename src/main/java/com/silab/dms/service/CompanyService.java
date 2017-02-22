package com.silab.dms.service;

import java.util.List;

import com.silab.dms.model.Company;

public interface CompanyService {
	
	public List<Company> retrieveAllCompanies();

    Company save(Company company);
}
