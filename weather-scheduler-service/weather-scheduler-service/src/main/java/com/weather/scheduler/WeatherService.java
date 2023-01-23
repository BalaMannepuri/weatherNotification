package com.weather.scheduler;

import com.weather.scheduler.model.UserInfo;
import com.weather.scheduler.model.WeatherResponse;
import com.weather.scheduler.proxy.AppNotificationProxy;
import com.weather.scheduler.proxy.EmailNotificationProxy;
import com.weather.scheduler.proxy.SmsNotificationProxy;
import com.weather.scheduler.proxy.WeatherProxy;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class WeatherService {
    @Autowired
    private SmsNotificationProxy smsNotificationProxy;

    @Autowired
    private EmailNotificationProxy emailNotificationProxy;

    @Autowired
    private AppNotificationProxy appNotificationProxy;

    @Autowired
    private WeatherProxy weatherProxy;

    @CircuitBreaker(name="default",fallbackMethod = "handlingSmsNotification")
    public void smsNotification(UserInfo userInfo, Integer temperature) {
        smsNotificationProxy.sendNotification(userInfo, temperature);
    }

    @CircuitBreaker(name="default",fallbackMethod = "handlingEmailNotification")
    public void emailNotification(UserInfo userInfo, Integer temperature) {
        emailNotificationProxy.sendNotification(userInfo, temperature);
    }

    @CircuitBreaker(name="default",fallbackMethod = "handlingAppNotification")
    public void appNotification(UserInfo userInfo, Integer temperature) {
        appNotificationProxy.sendNotification(userInfo, temperature);
    }

    @CircuitBreaker(name="default",fallbackMethod = "handlingWeatherCall")
    public WeatherResponse getTemperature(@PathVariable String city) {
        return weatherProxy.getTemperature(city).getBody();
    }

    public WeatherResponse handlingWeatherCall(Exception e) {
        System.out.println("Sending Hardcoded Values");
        return new WeatherResponse("", 40);
    }
    public void handlingSmsNotification(Exception ex) {
        System.out.println("Circuit Breaker Action Performs -> Sending SMS Notification");
    }

    public void handlingEmailNotification(Exception ex) {
        System.out.println("Circuit Breaker Action Performs -> Sending Email Notification");
    }
    public void handlingAppNotification(Exception ex) {
        System.out.println("Circuit Breaker Action Performs -> Sending App Notification");
    }
}
