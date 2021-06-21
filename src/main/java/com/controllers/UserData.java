package com.controllers;



import java.io.Serializable;

/**
 * The type User data.
 */
public class UserData implements Serializable {
    /**
     * The Id.
     */
    long id=-1;

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }
}
