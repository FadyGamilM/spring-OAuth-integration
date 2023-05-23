package com.springoauth.springoauth.events;

import org.springframework.context.ApplicationEvent;

import com.springoauth.springoauth.domain.User;

public class RegisterationCompletedEvent extends ApplicationEvent {

    // the url that we will send to the user in the emeial
    private String verificationUrl;
    private User user;

    public RegisterationCompletedEvent(User user, String url) {
        super(user);
        this.user = user;
        this.verificationUrl = url;
    }

}