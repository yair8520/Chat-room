package com.controllers;

public class MessagePair {
    private String message;
    private String author;
    private long userId;

   public MessagePair(String message, String author, long userId){
       this.message = message;
       this.author = author;
       this.userId=userId;
   }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }

    public long getUserId() {
        return userId;
    }
}
