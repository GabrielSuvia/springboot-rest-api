package com.socialPeople.webredsocial.auth.dto;

public class Auth {

    private String email;
    private String password;

    public Auth() {
    }

    public Auth(String email, String password) {
        this.email = email;
        this.password = password;
    }
    // getter and setter

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

}
