package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.PrimitiveProcessDao;
import com.silab.dms.model.PrimitiveProcess;

@Service("primitiveProcessService")
@Transactional
public class PrimitiveProcessServiceImpl implements PrimitiveProcessService{

	@Autowired
	PrimitiveProcessDao primitiveProcessDao;
	
	@Override
	public List<PrimitiveProcess> retrievePrimitiveProccesses() {
		return primitiveProcessDao.retrievePrimitiveProcesses();
	}

}
