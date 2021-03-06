package com.silab.dms.service;

import java.util.List;

import com.silab.dms.model.Company;
import com.silab.dms.model.ComplexProcess;

public interface ComplexProcessService {

	public List<ComplexProcess> retrieveComplexProcesses();
	public List<ComplexProcess> retrieveComplexProcessesByCompany(Company company);
}
