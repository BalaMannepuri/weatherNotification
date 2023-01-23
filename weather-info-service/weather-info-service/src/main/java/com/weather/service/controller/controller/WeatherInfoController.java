package com.weather.service.controller.controller;

import com.weather.service.controller.models.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class WeatherInfoController {
    @Value("${temp.min}")
    private Integer minimum;
    @Value("${temp.max}")
    private Integer maximum;
    @GetMapping("/weather/{city}")
    public ResponseEntity<WeatherResponse> getTemperature(@PathVariable String city) {
        Random r = new Random();
        WeatherResponse response = new WeatherResponse();
        response.setTemperature(r.nextInt(maximum-minimum) + minimum);
        response.setCity(city);
        return new ResponseEntity<WeatherResponse>(response, HttpStatus.OK);
    }
}
