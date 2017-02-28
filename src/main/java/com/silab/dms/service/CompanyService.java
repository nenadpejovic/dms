package com.silab.dms.service;

import java.util.List;

import com.silab.dms.model.Company;
import com.silab.dms.model.User;

public interface CompanyService {
	
	public List<Company> retrieveAllCompanies();

    public Company save(Company company);
    
}
