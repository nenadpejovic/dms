package com.silab.dms.controllers.dto;

/**
 * Created by msav on 2/5/2017.
 */
public class SignupInfo {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    public SignupInfo() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
