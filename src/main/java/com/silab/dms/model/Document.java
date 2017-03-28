/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.silab.dms.model;

import javax.persistence.*;
import javax.validation.constraints.Size;


/**
 *
 * @author PredragiNenad
 */
@Entity
@Table(name="document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="documentId")
    private int  id;

    @Column(name="name")
    @Size(min = 3, max = 40)
    private String name;

    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName="companyId", nullable = false)
    private Company company;

    @Column(name = "modelPath")
    private String modelPath;

    @ManyToOne
    @JoinColumn(name = "documentTypeId", referencedColumnName="id", nullable = false)
    private DocumentType documentType;

    public Document(String modelPath) {
        this.modelPath = modelPath;
    }

    public Document(String name, Company company, String modelPath, DocumentType documentType) {
        this.name = name;
        this.company = company;
        this.modelPath = modelPath;
        this.documentType = documentType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Document))
            return false;
        Document other = (Document) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return name;
    }
    
    public Document(){
    	
    }


}
