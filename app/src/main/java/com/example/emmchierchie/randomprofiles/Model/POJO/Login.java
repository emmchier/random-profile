package com.example.emmchierchie.randomprofiles.Model.POJO;

public class Login {
    private String username;

    public Login(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Login{" + "username='" + username + '\'' + '}';
    }
}
