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

/**
 * create some com.beans witn various scopes using QUALIFIERS (method names)
 */
@Configuration
public class BeanConfiguration {


    private  UserServices userServices;

    /**
     * Instantiates a new Bean configuration.
     *
     * @param userServices the user services
     */
    @Autowired
    public BeanConfiguration(UserServices userServices) {
        this.userServices = userServices;
    }

    /**
     * Id user data.
     *
     * @return the user data
     */
    /* session scope */
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public UserData id() {
        System.out.println("BeanConfiguration");
        return new UserData();
    }

    /**
     * Session listener with metrics servlet listener registration bean.
     *
     * @return the servlet listener registration bean
     */
    @Bean
    public ServletListenerRegistrationBean<SessionListener> sessionListenerWithMetrics() {
        ServletListenerRegistrationBean<SessionListener> listenerRegBean = new ServletListenerRegistrationBean<>();

        listenerRegBean.setListener(new SessionListener(userServices));
        return listenerRegBean;
    }
}
