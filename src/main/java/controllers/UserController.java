package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String getLoginPage(Model model) {
        return "login";
    }

}

