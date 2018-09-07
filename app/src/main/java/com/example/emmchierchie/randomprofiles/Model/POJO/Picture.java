package com.example.emmchierchie.randomprofiles.Model.POJO;

public class Picture {
    private String large;

    public Picture(String large) {
        this.large = large;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "Picture{" + "large='" + large + '\'' + '}';
    }
}
