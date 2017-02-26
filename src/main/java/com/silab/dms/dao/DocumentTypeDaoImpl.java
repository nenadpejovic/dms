package com.silab.dms.dao;

import java.util.List;

import com.silab.dms.controllers.dto.DocumentTypeDto;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.silab.dms.model.DocumentType;

@Repository("documentType")
public class DocumentTypeDaoImpl extends AbstractDao<Integer, DocumentType> implements DocumentTypeDao{

	@Override
	public List<DocumentType> retrieveDocumentTypes() {
		Criteria criteria = createEntityCriteria();
		return (List<DocumentType>)criteria.list();
	}

	@Override
	public void saveDocumentType(DocumentType documentType) {
		persist(documentType);
	}

	@Override
	public DocumentType updateAfterInitialCreation(DocumentTypeDto documentTypeDto) {
		Query query = getSession().createQuery("from DocumentType where modelPath = :modelPath");
		query.setParameter("modelPath", "baza.sql");
		List<DocumentType> types = query.list();
		types.stream()
				.findAny()
				.ifPresent(dt -> {
					dt.setDescription(documentTypeDto.getDocumentTypeDescription());
					dt.setTypeName(documentTypeDto.getDocumentTypeName());
					getSession().update(dt);
				});
		return null;
	}


}
