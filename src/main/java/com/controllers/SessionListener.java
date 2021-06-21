package com.controllers;
import com.beans.UserServices;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionListener implements HttpSessionListener {
    private final UserServices userServices;

    //inject from BeanConfiguration class
    public SessionListener(UserServices userServices) {
        super();
        this.userServices = userServices;
    }

    public void sessionDestroyed(final HttpSessionEvent event) {
        System.out.println("i am here!!");

        System.out.print("sessionDestroyed");
        UserData q = (UserData) event.getSession().getAttribute("scopedTarget.id");
        var deleteUser = userServices.findById(q.getId()).get();
        deleteUser.setAliveState(false);
        userServices.addUser(deleteUser, false);
    }

}

