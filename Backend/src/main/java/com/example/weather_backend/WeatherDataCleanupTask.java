package com.example.weather_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import jakarta.transaction.Transactional;
import java.time.LocalDateTime;

@Component
public class WeatherDataCleanupTask {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Scheduled(fixedRate = 600000) // 10 minutes
    @Transactional
    public void cleanOldWeatherData() {
        weatherDataRepository.deleteAllByTimestampBefore(LocalDateTime.now().minusMinutes(10));
    }
}

