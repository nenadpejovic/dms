package com.silab.dms.dao;

import java.util.List;
import java.util.Set;

import com.silab.dms.controllers.dto.DocumentTypeDto;
import com.silab.dms.model.DocumentType;

public interface DocumentTypeDao {

	public List<DocumentType> retrieveDocumentTypes();

    public void saveDocumentType(DocumentType documentType);

    public DocumentType updateAfterInitialCreation(DocumentTypeDto documentTypeDto);

    public Set<DocumentType> retrieveDocumentTypesForCompany(long vat);
}
