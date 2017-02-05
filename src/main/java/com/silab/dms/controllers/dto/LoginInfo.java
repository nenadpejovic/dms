package com.silab.dms.controllers.dto;

/**
 * Created by msav on 2/5/2017.
 */
public class LoginInfo {

    private String username;
    private String password;

    public LoginInfo() {
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
