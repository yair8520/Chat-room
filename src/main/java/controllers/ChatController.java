package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
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

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chatPage(Model model, HttpServletRequest request) {
        insert_name_user(model);

        return "chatPage";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chatPage1(Model model) {
        System.out.println("post");
        return "chatPage";
    }
    @RequestMapping(value = "/chat/newMessage", method = RequestMethod.POST)
    public String new_message(@RequestParam (name="message_input") String message, Model model) {
        Message new_message=new Message(message,sessionScopeId.getId());
        messageServices.addMessage(new_message);
        insert_name_user(model);
        model.addAttribute("topFiveMessages",messageServices.get5Message(sessionScopeId.getId()));
        return "chatPage";
    }

    private void insert_name_user(Model model)
    {
        Optional<User> s = this.userServices.findById(sessionScopeId.getId());
        model.addAttribute("f_name", s.get().getFirstName());
        model.addAttribute("l_name", s.get().getLastName());
    }

}
