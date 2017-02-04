package com.silab.dms.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.DocumentType;

@Repository("documentType")
public class DocumentTypeDaoImpl extends AbstractDao<Integer, DocumentType> implements DocumentTypeDao{

	@Override
	public List<DocumentType> retrieveDocumentTypes() {
		Criteria criteria = createEntityCriteria();
		return (List<DocumentType>)criteria.list();
	}

	
}
