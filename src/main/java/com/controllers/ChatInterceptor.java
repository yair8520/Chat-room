package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * The type Chat interceptor.
 */
public class ChatInterceptor implements HandlerInterceptor {

    /**
     * Instantiates a new Chat interceptor.
     */
    public ChatInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getSession(false) == null) {
            response.sendRedirect("/error/notLoggedIn");
            return false;
        }
        return true;
    }

}