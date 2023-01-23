package com.sms.notification.controller;

import com.sms.notification.models.SmsNotification;
import com.sms.notification.models.UserInfo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsNotificationController {

    @Value("${sms.message}")
    private String message;

    @Autowired
    private SmsNotification smsNotification;

    @PostMapping("/sms/notification/{temperature}")
    public ResponseEntity<String> sendNotification(@Valid @RequestBody UserInfo userInfo, @PathVariable Integer temperature) {
        smsNotification.sendNotification(String.format(message, userInfo.getName(), userInfo.getCity(), temperature), userInfo.getPhone());
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
