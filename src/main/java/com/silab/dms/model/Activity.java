package com.silab.dms.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue
    @Column(name = "activityId")
    private long activityId;

    @ManyToOne
    @JoinColumn(name = "processId", referencedColumnName = "processId", nullable = false)
    private PrimitiveProcess process;

    @Column(name = "activityName")
    @Range(min = 3, max = 50)
    private String activityName;

    @ManyToOne
    @JoinColumn(name = "documentId", referencedColumnName = "documentId", nullable = false, insertable = false, updatable = false)
    private Document inputDocument;

    @ManyToOne
    @JoinColumn(name = "documentId", referencedColumnName = "documentId", nullable = false, insertable = false, updatable = false)
    private Document outputDocument;

    public Activity(PrimitiveProcess process, String activityName, Document inputDocument, Document outputDocument) {
        this.process = process;
        this.activityName = activityName;
        this.inputDocument = inputDocument;
        this.outputDocument = outputDocument;
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

    public Document getInputDocument() {
        return inputDocument;
    }

    public void setInputDocument(Document inputDocument) {
        this.inputDocument = inputDocument;
    }

    public Document getOutputDocument() {
        return outputDocument;
    }

    public void setOutputDocument(Document outputDocument) {
        this.outputDocument = outputDocument;
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
        result = 31 * result + getProcess().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return activityName;
    }
}
