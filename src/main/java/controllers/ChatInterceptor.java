package controllers;

import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * this class intercepts all requests and displays statistics: request processing duration
 * <p>
 * it also demonstrates how to inject a bean (you cannot use Spring @Autowired in a
 * HandlerInterceptor but you can receive the bean via the ctor - from the configuration class)
 */

public class ChatInterceptor implements HandlerInterceptor {

    public ChatInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.print("-------- preHandle ---    ");

        if (request.getSession(false)==null) {
            response.sendRedirect("/login");
            return false;
       }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
                           Object handler, ModelAndView modelAndView) throws Exception {

        //System.out.print("-------- postHandle ---: ");
        //System.out.println("Request URL: " + request.getRequestURL());

        // You can add attributes in the modelAndView
        // and use that in the view page
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
                                Object handler, Exception ex) throws Exception {
        //System.out.print("-------- afterCompletion ---: ");


    }

}