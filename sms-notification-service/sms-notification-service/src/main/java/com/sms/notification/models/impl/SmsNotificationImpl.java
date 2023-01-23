package com.sms.notification.models.impl;

import com.sms.notification.models.SmsNotification;
import org.springframework.stereotype.Component;

@Component
public class SmsNotificationImpl implements SmsNotification {

    @Override
    public void sendNotification(String text, String email) {
        System.out.println("SMS: \n"+ text);
    }
}
