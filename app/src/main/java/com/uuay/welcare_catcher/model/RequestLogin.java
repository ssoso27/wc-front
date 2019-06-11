package com.uuay.welcare_catcher.model;

public class RequestLogin {
    public final String email;
    public final String password;

    public RequestLogin(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
