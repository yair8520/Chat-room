
package com.controllers;

import com.beans.MessageServices;
import com.beans.UserServices;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;


@WebListener
public class SessionListener implements HttpSessionListener {
    private final AtomicInteger activeSessions;

    @Autowired
      UserServices userServices;


    public SessionListener( ) {
        super();
        activeSessions = new AtomicInteger();
    }


    public int getTotalActiveSession() {
        return activeSessions.get();
    }

    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
        System.out.println("sessionCreated +++ Total active session are " + activeSessions.get());
    }
    public void sessionDestroyed(final HttpSessionEvent event) {
        activeSessions.decrementAndGet();
        System.out.println("sessionDestroyed --- Total active session are " + activeSessions.get());


        UserData q= (UserData) event.getSession().getAttribute("scopedTarget.id");
        var deleteUser=userServices.findById(q.getId()).get();
        deleteUser.setAliveState(false);
        userServices.addUser(deleteUser,false);


    }
}

