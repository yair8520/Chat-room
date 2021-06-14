
package com.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorCon implements ErrorController {

    @RequestMapping("/error")
    public String displayError() {
        return "ErrorPage";
    }

    @RequestMapping("/error/notLoggedIn")
    public String notLoggedIn() {
        return "NotLoggedIn";
    }
}
