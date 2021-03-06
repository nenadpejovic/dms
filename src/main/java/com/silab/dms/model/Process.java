package com.silab.dms.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;

import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "process")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="processType",discriminatorType=DiscriminatorType.STRING)
@Proxy(lazy = false)
@JsonTypeInfo(
	    use = JsonTypeInfo.Id.NAME,
	    include = JsonTypeInfo.As.PROPERTY,
	    property = "type")
	@JsonSubTypes({
	    @Type(value = ComplexProcess.class, name = "ComplexProcess"),
	    @Type(value = PrimitiveProcess.class, name = "PrimitiveProcess")})
public abstract class Process {
    @Id
    @GeneratedValue
    @Column(name = "processId")
    private long processId;

    @ManyToOne
    @JoinColumn(name = "companyId", referencedColumnName="companyId", nullable = false)
    private Company company;

    @Column(name = "processName")
    private String processName;

    @ManyToOne
    @JoinColumn(name = "parentId", referencedColumnName = "processId", nullable = true)
    private Process parentProcess;

	public void setProcessId(long processId) {
		this.processId = processId;
	}

	public Process() {
    }

    public Process(Company company, String processName, Process parentProcess) {
    	this.company = company;
        this.processName = processName;
        this.parentProcess = parentProcess;
    }

	public long getProcessId() {
        return processId;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Process getParentProcess() {
        return parentProcess;
    }

    public void setParentProcess(Process parentProcess) {
        this.parentProcess = parentProcess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Process process = (Process) o;

        if (getProcessId() != process.getProcessId()) return false;
        if (!getCompany().equals(process.getCompany())) return false;
        return getParentProcess() != null ? getParentProcess().equals(process.getParentProcess()) : process.getParentProcess() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getProcessId() ^ (getProcessId() >>> 32));
        result = 31 * result + getCompany().hashCode();
        result = 31 * result + (getParentProcess() != null ? getParentProcess().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return processName;
    }
}
