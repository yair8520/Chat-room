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

    private long user_id;

    public Message(String message, long user_id) {
        this.message = message;
        this.user_id = user_id;
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

    public long getUser_id() {return user_id; }

    public void setUser_id(long user_id) { this.user_id = user_id; }
}
