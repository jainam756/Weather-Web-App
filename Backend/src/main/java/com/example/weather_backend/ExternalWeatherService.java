package com.example.weather_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;

@Service
public class ExternalWeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;

    // Inject the WeatherDataRepository
    private final WeatherDataRepository weatherDataRepository;

    // Use constructor injection for the repository
    @Autowired
    public ExternalWeatherService(WeatherDataRepository weatherDataRepository) {
        this.restTemplate = new RestTemplate();
        this.weatherDataRepository = weatherDataRepository;
    }

    public WeatherData fetchWeatherData(String city) {
        // Check the database first
        WeatherData existingData = weatherDataRepository
                .findTopByLocationAndTimestampAfterOrderByTimestampDesc(city, LocalDateTime.now().minusMinutes(10));

        // If the data present in db, use it
        if (existingData != null) {
            return existingData;
        }

        // Data is not present in db call the external API
        String url = String.format(apiUrl, city, apiKey);
        WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class);

        WeatherData weatherData = new WeatherData();
        assert response != null;
        weatherData.setLocation(response.getName());
        weatherData.setTemperature(response.getMain().getTemp());
        weatherData.setHumidity(response.getMain().getHumidity());
        weatherData.setWindSpeed(response.getWind().getSpeed());
        weatherData.setDescription(response.getWeather().get(0).getMain());
        weatherData.setTimestamp(LocalDateTime.now()); // Set the current timestamp

        // Save the new weather data to the database before returning it
        return weatherDataRepository.save(weatherData);
    }
}
