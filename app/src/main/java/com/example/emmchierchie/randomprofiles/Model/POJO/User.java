package com.example.emmchierchie.randomprofiles.Model.POJO;

public class User {
    private Picture picture;
    private Name name;
    private String email;
    private Login login;

    public User(Picture picture, Name name, String email, Login login) {
        this.picture = picture;
        this.name = name;
        this.email = email;
        this.login = login;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
