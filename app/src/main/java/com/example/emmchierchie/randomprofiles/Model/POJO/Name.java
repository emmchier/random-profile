package com.example.emmchierchie.randomprofiles.Model.POJO;

import android.os.Parcel;
import android.os.Parcelable;

public class Name {
    private String first;
    private String last;

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Name{" +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' + '}';
    }
}
