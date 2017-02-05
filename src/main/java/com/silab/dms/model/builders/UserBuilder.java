package com.silab.dms.model.builders;

import com.silab.dms.Utils.Role;
import com.silab.dms.model.Company;
import com.silab.dms.model.User;

public class UserBuilder {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Company company;
    private Role role;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder setCompany(Company company) {
        this.company = company;
        return this;
    }

    public UserBuilder setRole(Role role) {
        this.role = role;
        return this;
    }

    public User createUser() {
        return new User(firstName, lastName, username, password, company, role);
    }
}