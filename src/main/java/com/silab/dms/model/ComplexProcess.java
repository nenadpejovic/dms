package com.silab.dms.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "complex_process")
@DiscriminatorValue(value = "complex")
@Proxy(lazy = false)
public class ComplexProcess extends Process {
	
    @OneToMany(mappedBy = "processId", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private Set<Process> childProcesses;

    public ComplexProcess(){
    	
    }
    public ComplexProcess(Company company, String processName, Process parentProcess, Set<Process> childProcesses) {
        super(company, processName, parentProcess);
        this.childProcesses = childProcesses;
    }

    @JsonIgnore
    public Set<Process> getChildProcesses() {
        return childProcesses;
    }

    public void setChildProcesses(Set<Process> childProcesses) {
        this.childProcesses = childProcesses;
    }
}
