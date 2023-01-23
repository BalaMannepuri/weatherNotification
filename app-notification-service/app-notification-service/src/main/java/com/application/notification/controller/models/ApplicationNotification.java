package com.application.notification.controller.models;

import org.springframework.stereotype.Service;

@Service
public interface ApplicationNotification {
    public void sendNotification(String text);
}
