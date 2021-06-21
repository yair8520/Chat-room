
package com.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The type Error con.
 */
@Controller
public class ErrorCon implements ErrorController {

    /**
     * Display error string.
     *
     * @return the string
     */
    @RequestMapping("/error")
    public String displayError() {
        return "ErrorPage";
    }

    /**
     * Not logged in string.
     *
     * @return the string
     */
    @RequestMapping("/error/notLoggedIn")
    public String notLoggedIn() {
        return "NotLoggedIn";
    }
}
