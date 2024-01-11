package com.example.weather_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @Autowired
    ExternalWeatherService externalWeatherService;

    @GetMapping
    public ResponseEntity<?> getWeatherData(@RequestParam String city) {

        WeatherData weatherData = externalWeatherService.fetchWeatherData(city);
        return ResponseEntity.ok(weatherData);
    }
}
