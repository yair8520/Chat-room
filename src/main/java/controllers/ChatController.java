package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.persistence.Tuple;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Vector;

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
    public String chatPage(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            if (!(userServices.findById(sessionScopeId.getId()).get().getAliveState())) {
                return "/login";
            }
        } catch (Exception e) {
            System.out.println("sadfsd");
            response.sendRedirect("/login");
        }
        insert_name_user(model);
        return "chatPage";
    }

    @RequestMapping(value = "/newMessage", method = RequestMethod.POST)
    @ResponseBody
    public List<MessagePair> new_message(@RequestBody String message) {

        long id = sessionScopeId.getId();
        Message new_message = new Message(message, id);
        messageServices.addMessage(new_message);
        List<MessagePair> authorAndMessage = add_authors();

        return add_authors();
    }


    private List<MessagePair> add_authors() {
        List<MessagePair> authorAndMessage = new Vector<MessagePair>();
        var fiveMessages = messageServices.get5Message();
        for (var message : fiveMessages) {
            var author = userServices.findById(message.getuserId());
            var ma = new MessagePair(message.getMessage(), author.get().toString());
            authorAndMessage.add(ma);
        }

        return authorAndMessage;
    }


    private void insert_name_user(Model model) {
        Optional<User> s = this.userServices.findById(sessionScopeId.getId());
        model.addAttribute("f_name", s.get().getFirstName());
        model.addAttribute("l_name", s.get().getLastName());
    }


}
