package com.weather.scheduler.proxy;

import com.weather.scheduler.model.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "weather-info-service", url = "localhost:8500")
public interface WeatherProxy {

    @GetMapping("/weather/{city}")
    ResponseEntity<WeatherResponse> getTemperature(@PathVariable String city);

}
