package controllers;


import javax.persistence.*;

@Entity
@Table
public class Message {

    public Message() {
    }

    private String message;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long userId;

    public Message(String message, long userId) {
        this.message = message;
        this.userId = userId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getuserId() {return userId; }

    public void setuserId(long user_id) { this.userId = userId; }
}