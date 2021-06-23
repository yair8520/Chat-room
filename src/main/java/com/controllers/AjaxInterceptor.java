package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The type Ajax interceptor.
 * Catches all calls from ajax
 */
public class AjaxInterceptor implements HandlerInterceptor {

    /**
     * Instantiates a new Ajax interceptor.
     */
    public AjaxInterceptor(){}
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (request.getSession(false) == null) {
           response.sendError(404);
            return false;
        }
        return true;
    }

}
