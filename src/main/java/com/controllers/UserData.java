package com.controllers;


import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component(value="id")
public class UserData implements Serializable {
    long id=-1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
