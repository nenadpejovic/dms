package com.silab.dms.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "complex_process")
@DiscriminatorValue(value = "complex")
public class ComplexProcess extends Process {
    @OneToMany(mappedBy = "processId")
    @JsonManagedReference
    private Set<Process> childProcesses;

    public ComplexProcess(Company company, String processName, Process parentProcess, Set<Process> childProcesses) {
        super(company, processName, parentProcess);
        this.childProcesses = childProcesses;
    }

    public Set<Process> getChildProcesses() {
        return childProcesses;
    }

    public void setChildProcesses(Set<Process> childProcesses) {
        this.childProcesses = childProcesses;
    }
}
