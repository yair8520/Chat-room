package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjaxInterceptor implements HandlerInterceptor {

    @Resource(name = "id")
    UserData sessionScopeId;
    public AjaxInterceptor(){}
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getSession(false) == null) {
            response.sendError(404);
            System.out.print("-------- 404 error true---  ");
            return false;
        }
        System.out.print("-------- 404 error false  ---    ");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {


    }
}
