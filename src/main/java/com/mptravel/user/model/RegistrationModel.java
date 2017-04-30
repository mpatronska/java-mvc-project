package com.mptravel.user.model;


import com.mptravel.user.validation.IsPasswordsMatching;

import javax.validation.constraints.Size;

@IsPasswordsMatching
public class RegistrationModel {

    @Size(min = 5, message = "Invalid username. It should be at least 5 symbols.")
    private String username;

    @Size(min = 5, message = "Invalid password. It should be at least 5 symbols.")
    private String password;

    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
