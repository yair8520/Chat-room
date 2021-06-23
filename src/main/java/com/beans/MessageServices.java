package com.beans;

import com.controllers.MessagePair;
import com.repo.Message;
import com.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 *  Implements the access functions to a Message's database from MessageRepo
 */
@Service
public class MessageServices {
    /**
     * The Message repo.
     */
    private final MessageRepo messageRepo;

    /**
     * Instantiates a new Message services.
     *
     * @param messageRepo the message repo
     */
    @Autowired
    public MessageServices(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    /**
     * Add message.
     *
     * @param message the message to add
     */
    public void addMessage(Message message){messageRepo.save(message);}

    /**
     * Gets 5 message.
     *
     * @return the 5 message
     */
    public List<Message> get5Message() {

        var s= messageRepo.findFirst5ByOrderByIdDesc();
        Collections.reverse(s);
        return  s;
    }

    /**
     * Gets user messages.
     *
     * @param id the id of user
     * @return the user messages
     */
    public List<Message> getUserMessages(long id) {
        return messageRepo.findAllByUserId(id);
    }

    /**
     * Find all by message list.
     *
     * @param message the message
     * @return the list
     */
    public List<Message> findAllByMessageStartingWith(String message){
        return messageRepo.findAllByMessageStartingWith(message);}

}
