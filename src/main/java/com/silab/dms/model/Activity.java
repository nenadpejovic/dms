package com.silab.dms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "activity")
@Proxy(lazy = false)
public class Activity {
    @Id
    @GeneratedValue
    @Column(name = "activityId")
    private long activityId;

    @ManyToOne
    @JoinColumn(name = "processId",referencedColumnName="processId", nullable = false)
    @JsonIgnore
    private PrimitiveProcess process;

    @Column(name = "activityName")
    private String activityName;

    @ManyToOne
    @JoinColumn(name = "inputDocumentTypeId", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
    private DocumentType inputDocumentType;

    @ManyToOne
    @JoinColumn(name = "outputDocumentTypeId", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
    private DocumentType outputDocumentType;

    public Activity(PrimitiveProcess process, String activityName, DocumentType inputDocumentType, DocumentType outputDocumentType) {
        this.process = process;
        this.activityName = activityName;
        this.inputDocumentType = inputDocumentType;
        this.outputDocumentType = outputDocumentType;
    }

    public long getActivityId() {
        return activityId;
    }

    public PrimitiveProcess getProcess() {
        return process;
    }

    public void setProcess(PrimitiveProcess process) {
        this.process = process;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public DocumentType getInputDocumentType() {
        return inputDocumentType;
    }

    public void setInputDocumentType(DocumentType inputDocumentType) {
        this.inputDocumentType = inputDocumentType;
    }

    public DocumentType getOutputDocumentType() {
        return outputDocumentType;
    }

    public void setOutputDocumentType(DocumentType outputDocumentType) {
        this.outputDocumentType = outputDocumentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (getActivityId() != activity.getActivityId()) return false;
        return getProcess().equals(activity.getProcess());

    }

    @Override
    public int hashCode() {
        int result = (int) (getActivityId() ^ (getActivityId() >>> 32));
        result = 31 * result;
        return result;
    }

    @Override
    public String toString() {
        return activityName;
    }
    
    public Activity(){
    	
    }
}
