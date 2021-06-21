package com.repo;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * The type Message.
 */
@Entity
@Table
public class Message {

    /**
     * Instantiates a new Message.
     */
    public Message() {
    }

    /**
     * The Message.
     */
    private String message;
    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * The User id.
     */
    private long userId;


    /**
     * Instantiates a new Message.
     *
     * @param message the message
     * @param userId  the user id
     */
    public Message(String message, long userId) {
        this.message = message;
        this.userId = userId;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

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
     * Gets id.
     *
     * @return the id of user
     */
    public long getuserId() {return userId; }

    /**
     * Sets id.
     *
     * @param user_id the user id
     */
    public void setuserId(long user_id) { this.userId = userId; }
}