package com.silab.dms.model;

import javax.persistence.*;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "documentType")
public class DocumentType {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long documentTypeId;

    @Column(name = "name")
    private String typeName;

    @Column(name = "description")
    private String description;

    @Column(name = "modelPath")
    private String modelPath;

    public DocumentType(String typeName, String description, String modelPath) {
        this.typeName = typeName;
        this.description = description;
        this.modelPath = modelPath;
    }

    public long getDocumentTypeId() {
        return documentTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelPath() {
        return modelPath;
    }

    public void setModelPath(String modelPath) {
        this.modelPath = modelPath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentType that = (DocumentType) o;

        if (getDocumentTypeId() != that.getDocumentTypeId()) return false;
        return getModelPath().equals(that.getModelPath());

    }

    @Override
    public int hashCode() {
        int result = (int) (getDocumentTypeId() ^ (getDocumentTypeId() >>> 32));
        result = 31 * result + getModelPath().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return typeName;
    }
}
