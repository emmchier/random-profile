package com.example.emmchierchie.randomprofiles.Model.POJO;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserContainer {
    @SerializedName("results")
    private List<User> user;

    public UserContainer(List<User> user) {
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
