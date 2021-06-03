//package controllers;
//
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
///**
// * this class intercepts all requests and displays statistics: request processing duration
// *
// * it also demonstrates how to inject a bean (you cannot use Spring @Autowired in a
// * HandlerInterceptor but you can receive the bean via the ctor - from the configuration class)
// */
//
//public class SessionChatInterceptor implements HandlerInterceptor {
//
//    public SessionChatInterceptor() {
//    }
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
//            throws Exception {
//
//
//        System.out.print("-------- preHandle --- ");
//
//
//        if(request.getSession()==null)
//        {
//            response.sendRedirect("/login");
//            return false;
//        }
//        else
//            return true;
//
//        // filter can redirect response to a specific page
//        // response.sendRedirect("/error");
//
//        // return FALSE will block the request chaining!
//
//         // continue with the request to next filter or to controller
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
//                           Object handler, ModelAndView modelAndView) throws Exception {
//
//        //System.out.print("-------- postHandle ---: ");
//        //System.out.println("Request URL: " + request.getRequestURL());
//
//        // You can add attributes in the modelAndView
//        // and use that in the view page
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
//                                Object handler, Exception ex) throws Exception {
//        //System.out.print("-------- afterCompletion ---: ");
//
//
//    }
//
//}