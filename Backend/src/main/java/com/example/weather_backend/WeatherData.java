package com.example.weather_backend;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "weather_data")
public class WeatherData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "location")
    private String location;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "humidity")
    private Double humidity;

    @Column(name = "wind_speed")
    private Double windSpeed;

    @Column(name = "description")
    private String description;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    // Constructors, getters, and setters

    public WeatherData() {
    }

    // other getters and setters
    public String getDescription() {
        return description;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getTemperature() {
        return temperature;
    }

    public String getLocation() {
        return location;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Long getId() {
        return id;
    }


    //setters
    public void setDescription(String description) {
        this.description = description;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
