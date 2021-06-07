package com.repo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty(message = "firstName is mandatory")
    private String firstName;
    @NotEmpty(message = "lastName is mandatory")
    private String lastName;

    public boolean getAliveState() {
        return alive;
    }

    public void setAliveState(boolean alive) {
        this.alive = alive;
    }

    private boolean alive=false; //default dead

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User() {}


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName+" "+lastName;
    }
    /*public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }*/


}

