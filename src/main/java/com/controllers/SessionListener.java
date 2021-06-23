package com.controllers;
import com.beans.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * The type Session listener.
 */
@WebListener
@Component
public class SessionListener implements HttpSessionListener {

    /**
     * The User services.
     */
    private UserServices userServices;

    /**
     * Instantiates a new Session listener.
     *
     * @param userServices the user services
     */
    public SessionListener(UserServices userServices) {
        super();
        this.userServices = userServices;
    }

    public void sessionDestroyed(final HttpSessionEvent event) {
        UserData q = (UserData) event.getSession().getAttribute("scopedTarget.id");
        var deleteUser = userServices.findById(q.getId()).get();
        deleteUser.setAliveState(false);
        userServices.addUser(deleteUser, false);
    }


}

