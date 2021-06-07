package com.controllers;


import com.beans.MessageServices;
import com.beans.UserServices;
import com.repo.Message;
import com.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping(value = "/chat")
public class ChatController {

    private final UserServices userServices;
    private final MessageServices messageServices;
    @Resource(name = "id")
    UserData sessionScopeId;

    @Autowired
    public ChatController(UserServices userServices, MessageServices messageServices) {
        this.userServices = userServices;
        this.messageServices = messageServices;
    }

    @GetMapping
    public ModelAndView chatPage(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*if (!(userServices.findById(sessionScopeId.getId()).get().getAliveState())) {
            return new ModelAndView("redirect:" + "/login");
        }*/
        insert_name_user(model);
        return new ModelAndView("chatPage");
    }

    @RequestMapping(value = "/newMessage", method = RequestMethod.POST)
    @ResponseBody
    public List<MessagePair> new_message(@RequestBody String message) {

        long id = sessionScopeId.getId();
        Message new_message = new Message(message, id);
        messageServices.addMessage(new_message);
        return add_authors(messageServices.get5Message());
    }

    @RequestMapping(value = "/getConnectedUsers", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getConnectedUsers() throws IOException {
        return userServices.getConnectedUsers();
    }

    @RequestMapping(value = "/getAllMessages", method = RequestMethod.GET)
    @ResponseBody
    public List<MessagePair> getAllMessages() throws IOException {
        return add_authors(messageServices.get5Message());
    }

    @RequestMapping(value = "/searchByMessage", method = RequestMethod.POST)
    @ResponseBody
    public List<MessagePair> getAllMessages(@RequestBody String message) {
        return add_authors(messageServices.findAllByMessage(message));
    }

    @RequestMapping(value = "/searchByUser", method = RequestMethod.POST)
    @ResponseBody
    public List<MessagePair> searchByUser(@RequestBody String userName) {

        List<MessagePair> empty = new Vector<MessagePair>();
        var list = userName.split(" ");
        if (list.length < 2) {
            return add_authors(messageServices.getUserMessages(userServices.findByFirstName(list[0]).getId()));
        } else {
            return add_authors(messageServices.getUserMessages(userServices.findByFirstNameAndLastName(list[0], list[1]).getId()));
        }

    }

    private void insert_name_user(Model model) {
        Optional<User> s = this.userServices.findById(sessionScopeId.getId());
        model.addAttribute("f_name", s.get().getFirstName());
        model.addAttribute("l_name", s.get().getLastName());
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logOut() {
        userServices.findById(sessionScopeId.getId()).get().setAliveState(false);     //after logout user dead
        return new ModelAndView("redirect:" + "/login");
    }


    private List<MessagePair> add_authors(List<Message> s) {
        List<MessagePair> authorAndMessage = new Vector<MessagePair>();
        var fiveMessages = s;
        for (var message : fiveMessages) {
            var author = userServices.findById(message.getuserId());
            var ma = new MessagePair(message.getMessage(), author.get().toString());
            authorAndMessage.add(ma);
        }
        return authorAndMessage;
    }

}
