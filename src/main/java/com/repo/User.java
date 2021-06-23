package com.repo;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.sql.Timestamp;
import java.util.Date;

/**
 * The type User.
 */
@Entity
@Table
public class User {

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * The First name.
     */
    @NotEmpty(message = "firstName is mandatory")
    private String firstName;
    /**
     * The Last name.
     */
    @NotEmpty(message = "lastName is mandatory")
    private String lastName;

    /**
     * The Sql timestamp.
     */
    @Basic
    private Timestamp sqlTimestamp;

    /**
     * Gets alive state.
     *
     * @return the alive state
     */
    public boolean getAliveState() {
        return alive;
    }

    /**
     * Sets alive state.
     *
     * @param alive the alive
     */
    public void setAliveState(boolean alive) {
        this.alive = alive;
    }

    /**
     * The Alive.
     * default dead
     */
    boolean alive=false;

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     */
    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        sqlTimestamp=new Timestamp(System.currentTimeMillis());
    }

    /**
     * Instantiates a new User.
     */
    public User() {}


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

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets sql timestamp.
     *
     * @return the sql timestamp
     */
    public Timestamp getSqlTimestamp() {
        return sqlTimestamp;
    }

    /**
     * Sets sql timestamp.
     *
     * @param sqlTimestamp the sql timestamp
     */
    public void setSqlTimestamp(Timestamp sqlTimestamp) {
        this.sqlTimestamp = sqlTimestamp;
    }


    @Override
    public String toString() {
        return firstName+" "+lastName;
    }



}

