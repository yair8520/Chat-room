package com.controllers;



import java.io.Serializable;

public class UserData implements Serializable {
    long id=-1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
