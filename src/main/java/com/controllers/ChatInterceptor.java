package com.controllers;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


/**
 * this class intercepts all requests and displays statistics: request processing duration
 * <p>
 * it also demonstrates how to inject a bean (you cannot use Spring @Autowired in a
 * HandlerInterceptor but you can receive the bean via the ctor - from the configuration class)
 */

public class ChatInterceptor implements HandlerInterceptor {

    @Resource(name = "id")
    UserData sessionScopeId;

    public ChatInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getSession(false) == null) {
            response.sendRedirect("/error/notLoggedIn");
            System.out.print("-------- preHandle not session existed ---  ");
            return false;
        }
        System.out.print("-------- preHandle session  existed!!  ---    ");
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