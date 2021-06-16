package com;


//import com.controllers.SessionListener;
import com.beans.UserServices;
import com.controllers.SessionListener;
import com.controllers.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpSessionListener;

/**
 * create some com.beans witn various scopes using QUALIFIERS (method names)
 */
@Configuration
public class BeanConfiguration {


    private final UserServices userServices;

    @Autowired
    public BeanConfiguration(UserServices userServices) {
        this.userServices = userServices;
    }
    /* session scope */
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserData id() {
        System.out.println("BeanConfiguration");
        return new UserData();
    }
    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListenerWithMetrics() {
        ServletListenerRegistrationBean<SessionListener> listenerRegBean = new ServletListenerRegistrationBean<>();

        listenerRegBean.setListener(new SessionListener(userServices));
        return listenerRegBean;
    }
    @Bean
    public ServletListenerRegistrationBean<HttpSessionListener> sessionListener() {
        return new ServletListenerRegistrationBean<HttpSessionListener>(new SessionListener(userServices));
    }
}
