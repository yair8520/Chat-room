package com.beans;

import com.repo.Message;
import com.repo.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MessageServices {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageServices(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    public void addMessage(Message message){messageRepo.save(message);}

    public List<Message> get5Message() {

        var s= messageRepo.findFirst5ByOrderByDateTimeDesc();
        Collections.reverse(s);
        return   s;
    }

    public List<Message> getUserMessages(long id) {return messageRepo.findAllByUserId(id);}

    public List<Message> findAllByMessage(String message){return messageRepo.findAllByMessage(message);}
}
