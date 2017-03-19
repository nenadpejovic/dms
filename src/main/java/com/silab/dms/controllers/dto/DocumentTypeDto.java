package com.silab.dms.controllers.dto;

import com.silab.dms.model.Company;

/**
 * Created by msav on 2/26/2017.
 */
public class DocumentTypeDto {
    private String originalFilename;
    private String documentTypeName;
    private String documentTypeDescription;
    private Company company;

    public DocumentTypeDto() {
    }


    public String getOriginalFilename() {
        return originalFilename;
    }

    public void setOriginalFilename(String originalFilename) {
        this.originalFilename = originalFilename;
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}

