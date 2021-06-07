package com.controllers;

public class MessagePair {
    private String message;
    private String author;

   public MessagePair(String message, String author){
       this.message = message;
       this.author = author;
   }

    public String getAuthor() {
        return author;
    }

    public String getMessage() {
        return message;
    }
}
