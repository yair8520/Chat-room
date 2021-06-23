package com.controllers;

/**
 * The type Message pair.
 */
public class MessagePair {
    /**
     * The Message.
     */
    private  String message;
    /**
     * The Author.
     */
    private String author;
    /**
     * The User id.
     */
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
