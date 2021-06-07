package com.controllers;


import org.springframework.stereotype.Component;

@Component(value="id")
public class UserData {
    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
