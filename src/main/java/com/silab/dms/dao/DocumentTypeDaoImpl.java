package com.silab.dms.dao;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.silab.dms.controllers.dto.DocumentTypeDto;
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

	@Override
	public void saveDocumentType(DocumentType documentType) {
		persist(documentType);
	}

	@Override
	public DocumentType updateAfterInitialCreation(DocumentTypeDto documentTypeDto) {
		return retrieveDocumentTypes()
				.stream()
				.filter(dt -> dt.getModelPath().equalsIgnoreCase(documentTypeDto.getOriginalFilename()))
				.findFirst()
				.map(documentType -> fillDocumentTypeDataAndUpload(documentType, documentTypeDto))
				.get();
	}

	@Override
	public Set<DocumentType> retrieveDocumentTypesForCompany(long vat) {
		return retrieveDocumentTypes()
				.stream()
				.filter(documentType -> documentType.getCompany().getVat() == vat)
				.collect(Collectors.toSet());
	}

	private DocumentType fillDocumentTypeDataAndUpload(DocumentType documentType, DocumentTypeDto documentTypeDto) {
		documentType.setDescription(documentTypeDto.getDocumentTypeDescription());
		documentType.setTypeName(documentTypeDto.getDocumentTypeName());
		documentType.setCompany(documentTypeDto.getCompany());
		getSession().update(documentType);
		return documentType;
	}


}
