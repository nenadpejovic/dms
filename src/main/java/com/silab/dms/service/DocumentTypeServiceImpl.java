package com.silab.dms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silab.dms.dao.DocumentTypeDao;
import com.silab.dms.model.DocumentType;

@Service("documentTypeService")
@Transactional
public class DocumentTypeServiceImpl implements DocumentTypeService{

	@Autowired
	DocumentTypeDao documentTypeDao;
	
	@Override
	public List<DocumentType> retrieveDocumentTypes() {
		return documentTypeDao.retrieveDocumentTypes();
	}
	
}