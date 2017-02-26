package com.silab.dms.controllers.dto;

/**
 * Created by msav on 2/26/2017.
 */
public class DocumentTypeDto {
    private long documentTypeid;
    private String documentTypeName;
    private String documentTypeDescription;

    public DocumentTypeDto() {
    }

    public long getDocumentTypeid() {
        return documentTypeid;
    }

    public void setDocumentTypeid(long documentTypeid) {
        this.documentTypeid = documentTypeid;
    }

    public String getDocumentTypeName() {
        return documentTypeName;
    }

    public void setDocumentTypeName(String documentTypeName) {
        this.documentTypeName = documentTypeName;
    }

    public String getDocumentTypeDescription() {
        return documentTypeDescription;
    }

    public void setDocumentTypeDescription(String documentTypeDescription) {
        this.documentTypeDescription = documentTypeDescription;
    }
}

