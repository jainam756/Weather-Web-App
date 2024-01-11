package com.example.weather_backend;

import java.util.List;

public class WeatherResponse {

    private Main main;
    private Wind wind;
    private String name;

    private List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }
    public String getName() {
        return name;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public static class Main {
        private double temp;
        private double humidity;

        public double getTemp() {
            return temp;
        }

        public double getHumidity() {
            return humidity;
        }
    }

    public static class Wind {
        private double speed;

        public double getSpeed() {
            return speed;
        }
    }

    public static class Weather{
        private String main;

        public String getMain() {
            return main;
        }
    }


}

