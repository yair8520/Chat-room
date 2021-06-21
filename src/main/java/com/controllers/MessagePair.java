package com.controllers;

/**
 * The type Message pair.
 */
public class MessagePair {
    private String message;
    private String author;
    private long userId;

    /**
     * Instantiates a new Message pair.
     *
     * @param message the message
     * @param author  the author
     * @param userId  the user id
     */
    public MessagePair(String message, String author, long userId){
       this.message = message;
       this.author = author;
       this.userId=userId;
   }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
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
     * Gets user id.
     *
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }
}
