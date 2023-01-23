package com.email.notification.controller.models.impl;

import com.email.notification.controller.models.EmailNotification;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationImpl implements EmailNotification {

    @Override
    public void sendNotification(String text, String email) {
        System.out.println("Email: \n"+ text);
    }
}
