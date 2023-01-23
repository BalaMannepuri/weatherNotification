package com.weather.weatherservicesdiscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class WeatherServicesDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServicesDiscoveryApplication.class, args);
	}

}
