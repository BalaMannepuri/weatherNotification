package com.application.notification.controller.models.impl;

import com.application.notification.controller.models.ApplicationNotification;
import org.springframework.stereotype.Component;

@Component
public class ApplicationNotificationImpl implements ApplicationNotification {

    @Override
    public void sendNotification(String text) {
        System.out.println("Application: \n"+ text);
    }
}
