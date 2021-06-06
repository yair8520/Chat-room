package controllers;


import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSessionListener;

/**
 * create some beans witn various scopes using QUALIFIERS (method names)
 */
@Configuration
public class BeanConfiguration {

    /* session scope */
    @Bean
    @SessionScope
    public UserData  sessionScopeId() {
        return new UserData();
    }
    /*@Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListenerWithMetrics() {
        ServletListenerRegistrationBean<SessionListener> listenerRegBean = new ServletListenerRegistrationBean<>();

        listenerRegBean.setListener(new SessionListener());
        return listenerRegBean;
    }*/
   /* @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionListener());
    }*/
}
