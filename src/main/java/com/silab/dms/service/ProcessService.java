package com.silab.dms.service;

import java.util.List;

import com.silab.dms.model.ComplexProcess;
import com.silab.dms.model.Process;

public interface ProcessService {

	public List<Process> retrieveAllProcesses();

    public List<Process> getProcessesByCompany(long vat);
    
    public void save(Process p);
    
    public void deleteProcess(Process process);

    public void update(ComplexProcess parentProcess);
}
