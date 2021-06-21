package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ChatInterceptor implements HandlerInterceptor {

    public ChatInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getSession(false) == null) {
            response.sendRedirect("/error/notLoggedIn");
            System.out.print("-------- ChatInterceptor session not  existed ---  ");
            return false;
        }
        System.out.print("-------- ChatInterceptor session  existed!!  ---    ");
        return true;
    }

}