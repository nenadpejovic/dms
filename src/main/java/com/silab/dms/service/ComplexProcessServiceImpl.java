package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silab.dms.dao.ComplexProcessDao;
import com.silab.dms.model.ComplexProcess;

@Service("complexProcessService")
public class ComplexProcessServiceImpl implements ComplexProcessService{

	@Autowired
	ComplexProcessDao complexProcessDao;

	@Override
	public List<ComplexProcess> retrieveComplexProcesses() {
		return complexProcessDao.retrieveComplexProcesses();
	}
}
