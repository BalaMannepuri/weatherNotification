package com.weather.scheduler.proxy;

import com.weather.scheduler.model.UserInfo;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "sms-notification-service")
public interface SmsNotificationProxy {

    @PostMapping("/sms/notification/{temperature}")
    ResponseEntity<String> sendNotification(@RequestBody UserInfo userInfo, @PathVariable Integer temperature);

}
