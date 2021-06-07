//package com;
//
//
//import com.controllers.ChatInterceptor;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
///*
//    EXAMPLE: CONTROLLING THE STATIC FOLDER
//
//  here we register our interceptor class and the session listener
//  WebMvcConfigurer allows configuring all of the MVC:
// */
//@EnableWebMvc
//@Configuration
//public class FiltersConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        // if you want to apply filter only for REST controller: change the "/**" pattern
//       registry.addInterceptor(new ChatInterceptor()).addPathPatterns("/chat");
//    }
//
//}