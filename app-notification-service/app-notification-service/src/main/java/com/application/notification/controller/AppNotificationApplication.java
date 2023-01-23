package com.application.notification.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AppNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppNotificationApplication.class, args);
	}

}
