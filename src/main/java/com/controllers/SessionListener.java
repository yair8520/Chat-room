
package com.controllers;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;


@WebListener
public class SessionListener implements HttpSessionListener {
    private final AtomicInteger activeSessions;

    public SessionListener() {
        super();
        activeSessions = new AtomicInteger();
    }

    public int getTotalActiveSession() {
        return activeSessions.get();
    }

    public void sessionCreated(final HttpSessionEvent event) {
        activeSessions.incrementAndGet();
        System.out.println("SessionListener +++ Total active session are " + activeSessions.get());
    }
    public void sessionDestroyed(final HttpSessionEvent event) {
        activeSessions.decrementAndGet();
        System.out.println("SessionListener --- Total active session are " + activeSessions.get());
        //var s=event.getSession().getAttribute("id");
       // System.out.println(s);

    }
}

