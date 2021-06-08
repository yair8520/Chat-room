package com.controllers;

import com.beans.UserServices;
import com.repo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class loginController {
    private final UserServices userServices;


    @Resource(name = "id")
    UserData sessionScopeId;

    @Autowired
    public loginController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getm() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView setUser(@RequestParam(name = "firstName") String first_name,
                                @RequestParam(name = "lastName") String last_name, HttpServletRequest request, HttpServletResponse res) {
        if (userServices.findByFirstNameAndLastName(first_name, last_name) == null ||
                userServices.findByFirstNameAndLastName(first_name, last_name).getAliveState() == false) {
            User user = new User(first_name, last_name);
            long id = this.userServices.addUser(user);
            sessionScopeId.setId(id);
            request.getSession(true);


            ModelAndView modelAndView = new ModelAndView("redirect:/chat");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("dupUser", "The name is registered in the system. Please select a different name");

            return modelAndView;
        }
    }
}