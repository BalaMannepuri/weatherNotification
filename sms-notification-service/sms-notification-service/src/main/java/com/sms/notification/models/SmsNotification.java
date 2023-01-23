package com.sms.notification.models;

import org.springframework.stereotype.Service;

@Service
public interface SmsNotification {
    public void sendNotification(String message, String mobileNumber);
}
