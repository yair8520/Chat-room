package controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class ChatController {

    private final UserServices userServices;

    @Autowired
    public ChatController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String chatPage(@RequestParam(name = "id") long id , Model model, HttpServletRequest request) {

      Optional<User> s=this.userServices.findById(id);
      model.addAttribute("f_name",s.get().getFirstName());
      model.addAttribute("l_name",s.get().getLastName());

        return "chatPage";
    }

   @RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chatPage1(Model model) {
        System.out.println("post");
        return "chatPage";
    }
    /*@RequestMapping(value = "/chat", method = RequestMethod.POST)
    public String chatPage1(Model model) {
        System.out.println("post");
        return "chatPage";
    }*/


}
