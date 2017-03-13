package com.silab.dms.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;
import java.util.Set;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "primitive_process")
@DiscriminatorValue(value = "primitive")
public class PrimitiveProcess extends Process {

    @OneToMany(mappedBy = "activityId")
    private Set<Activity> activities;

    public PrimitiveProcess(){
    	
    }
    
    public PrimitiveProcess(Company company, String processName, Process parentProcess, Set<Activity> activities) {
        super(company, processName, parentProcess);
        this.activities = activities;
    }

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }
}
