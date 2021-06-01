package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
public class loginController {
    private final UserServices userServices;

    @Autowired
    public loginController(UserServices userServices) {
        this.userServices = userServices;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getm() {
        return "welcome";
    }





   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public ModelAndView  setUser(@RequestParam(name = "firstName") String first_name,
                                @RequestParam(name = "lastName") String last_name) {

       //session
       User user = new User(first_name,last_name);
       long id=this.userServices.addUser(user);

       ModelAndView modelAndView =  new ModelAndView("redirect:/chat");
       modelAndView.addObject("id" , id);
       return modelAndView;

   }

}
