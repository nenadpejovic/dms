package com.silab.dms.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import java.util.List;

/**
 * Created by msav on 1/29/2017.
 */
@Entity
@Table(name = "primitive_process")
@DiscriminatorValue(value = "primitive")
public class PrimitiveProcess extends Process {

    @OneToMany(mappedBy = "activityId")
    private List<Activity> activities;

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
