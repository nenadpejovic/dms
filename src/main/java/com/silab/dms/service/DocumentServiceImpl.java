/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.service;

import com.silab.dms.dao.DocumentDao;
import com.silab.dms.model.Document;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PredragiNenad
 */
@Service("documentService")
@Transactional
public class DocumentServiceImpl implements DocumentService{

    @Autowired
    DocumentDao documentDao;
    
    @Override
    public List<Document> retrieveAllDocuments() {
        return documentDao.retrieveAllDocuments();
    }

	@Override
	public List<Document> retrieveDocumentsByCompany(long vat) {
		return documentDao.retrieveDocumentsByCompany(vat);
	}
    
}
