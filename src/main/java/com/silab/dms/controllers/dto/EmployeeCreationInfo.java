package com.silab.dms.controllers.dto;

import com.silab.dms.model.Company;

/**
 * Created by msav on 2/25/2017.
 */
public class EmployeeCreationInfo {

    private String firstName;
    private String lastName;
    private String username;
    private Company company;

    public EmployeeCreationInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
