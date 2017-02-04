package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.ProcessDao;
import com.silab.dms.model.Process;

@Service("process")
@Transactional
public class ProcessServiceImpl implements ProcessDao{

	@Autowired
	ProcessDao processDao;
	
	@Override
	public List<Process> retrieveAllProcesses() {
		return processDao.retrieveAllProcesses();
	}

}
