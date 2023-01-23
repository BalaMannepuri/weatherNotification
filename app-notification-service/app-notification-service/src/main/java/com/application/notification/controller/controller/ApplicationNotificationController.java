package com.application.notification.controller.controller;

import com.application.notification.controller.models.UserInfo;
import com.application.notification.controller.models.ApplicationNotification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApplicationNotificationController {

    @Value("${app.message}")
    private String message;

    @Autowired
    private ApplicationNotification applicationNotification;


    @PostMapping("/app/notification/{temperature}")
    public ResponseEntity<String> sendNotification(@RequestBody UserInfo userInfo, @PathVariable Integer temperature) {
        applicationNotification.sendNotification(String.format(message,userInfo.getName(),userInfo.getCity(),temperature));
        return new ResponseEntity<String>("Success", HttpStatus.OK);
    }
}
