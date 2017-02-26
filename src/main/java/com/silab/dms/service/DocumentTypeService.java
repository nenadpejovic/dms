package com.silab.dms.service;

import java.util.List;

import com.silab.dms.controllers.dto.DocumentTypeDto;
import com.silab.dms.model.DocumentType;

public interface DocumentTypeService {

	public List<DocumentType> retrieveDocumentTypes();

    public void saveDocumentType(DocumentType documentType);

    public DocumentType updateAfterInitialCreation(DocumentTypeDto documentTypeDto);
}
