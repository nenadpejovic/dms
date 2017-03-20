package com.silab.dms.model;

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
@Table(name = "primitive_process")
@DiscriminatorValue(value = "primitive")
@Proxy(lazy = false)
public class PrimitiveProcess extends Process {


    @OneToMany(mappedBy = "process", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Activity> activities;
	
    public PrimitiveProcess(){
    	
    }
    
    public PrimitiveProcess(Company company, String processName, Process parentProcess, List<Activity> activities) {
        super(company, processName, parentProcess);
        this.activities = activities;
    }

    public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

}
