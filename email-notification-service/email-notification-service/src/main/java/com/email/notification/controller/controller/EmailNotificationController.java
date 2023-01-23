package com.email.notification.controller.controller;

import com.email.notification.controller.models.EmailNotification;
import com.email.notification.controller.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailNotificationController {

    @Value("${email.message}")
    private String message;

    @Autowired
    private EmailNotification emailnNotification;

    @PostMapping("/email/notification/{temperature}")
    public ResponseEntity<String> sendNotification(@RequestBody UserInfo userInfo, @PathVariable Integer temperature) {
        emailnNotification.sendNotification(String.format(message, userInfo.getName(), userInfo.getCity(), temperature), userInfo.getEmail());
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
