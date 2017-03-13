package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.ProcessDao;
import com.silab.dms.model.Process;

@Service("process")
@Transactional
public class ProcessServiceImpl implements ProcessService{

	@Autowired
	ProcessDao processDao;

	@Override
	public List<Process> retrieveAllProcesses() {
		return processDao.retrieveAllProcesses();
	}

	@Override
	public List<Process> getProcessesByCompany(long vat) {
		return processDao.retreiveProcessesByCompany(vat);
	}

	@Override
	public void save(Process p) {
		processDao.save(p);
		
	}

	@Override
	public void deleteProcess(Process process) {
		processDao.deleteProcess(process);
	}

}
