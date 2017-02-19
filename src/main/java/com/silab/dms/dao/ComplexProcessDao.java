package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.Company;
import com.silab.dms.model.ComplexProcess;
import com.silab.dms.model.PrimitiveProcess;

public interface ComplexProcessDao {

	public List<ComplexProcess> retrieveComplexProcesses();
	public List<ComplexProcess> retrieveComplexProcessesByCompany(Company company);
	
}
