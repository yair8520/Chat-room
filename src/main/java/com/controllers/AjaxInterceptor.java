package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxInterceptor implements HandlerInterceptor {

    public AjaxInterceptor(){}
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getSession(false) == null) {
           response.sendError(404);
            System.out.print("-------- AjaxInterceptor 404 ---  ");
            return false;
        }
        System.out.print("-------- AjaxInterceptor OK  ---    ");
        return true;
    }

}
