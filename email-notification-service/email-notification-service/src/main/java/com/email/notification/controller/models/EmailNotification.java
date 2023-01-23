package com.email.notification.controller.models;

import org.springframework.stereotype.Service;

@Service
public interface EmailNotification {
    public void sendNotification(String message, String email);
}
