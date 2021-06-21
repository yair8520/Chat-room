package com.repo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Date;

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

    @Basic
    private Timestamp sqlTimestamp;

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
        sqlTimestamp=new Timestamp(System.currentTimeMillis());
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

    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
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

