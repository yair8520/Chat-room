package controllers;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.annotation.SessionScope;

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
}
