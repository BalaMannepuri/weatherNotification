package com.weather.scheduler;

import com.weather.scheduler.model.UserInfo;
import com.weather.scheduler.model.WeatherResponse;
import com.weather.scheduler.proxy.WeatherProxy;
import com.weather.scheduler.repository.UserInfoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WeatherScheduler {

    @Autowired
    private WeatherService weatherService;
    @Autowired
    private UserInfoRepository userInfoRepository;

    private Logger logger = LoggerFactory.getLogger(WeatherScheduler.class);
    @Scheduled(cron = "${weather.info.cron}") // 0 0 */1 * * *
    public void scheduleTaskUsingCronExpression() {
        List<UserInfo> userInfo = userInfoRepository.findAll();
        List<String> cities = userInfo.stream().map(UserInfo::getCity).distinct().toList();
        for (String city : cities) {
            WeatherResponse weatherResponse = weatherService.getTemperature(city);
            List<UserInfo> cityUsersList = userInfoRepository.findByCity(city);
            for (UserInfo cityUser : cityUsersList) {
                Integer temp = weatherResponse.getTemperature();
                logger.info("User Name "+cityUser.getName()+"  Temperature : " + temp + " City: "+cityUser.getCity() + " Temperature: "+cityUser.getTemperature());
                if (cityUser.getSmsEnabled()&& cityUser.getTemperature()<=temp) {
                    weatherService.smsNotification(null,temp);
                }
                if (cityUser.getAppEnabled() && cityUser.getTemperature()<=temp) {
                    weatherService.appNotification(cityUser,temp);
                }
                if (cityUser.getEmailEnabled() && cityUser.getTemperature()<=temp) {
                    weatherService.emailNotification(cityUser,temp);
                }
            }
        }
    }
}
