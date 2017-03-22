package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.model.ComplexProcess;
import com.silab.dms.model.Process;

public interface ProcessDao {

	public List<Process> retrieveAllProcesses();

    public List<Process> retreiveProcessesByCompany(long vat);
    
    public void save(Process process);
    
    public void deleteProcess(Process process);

    public void update(ComplexProcess parentProcess);
}
