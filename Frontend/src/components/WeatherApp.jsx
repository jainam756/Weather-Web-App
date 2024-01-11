import React, { useState } from "react";
import "./WeatherApp.css";
import search_icon from "../assets/search.png";
import clear_icon from "../assets/clear.png";
import cloud_icon from "../assets/cloud.png";
import drizzle_icon from "../assets/drizzle.png";
import rain_icon from "../assets/rain.png";
import snow_icon from "../assets/snow.png";
import wind_icon from "../assets/wind.png";
import humidity_icon from "../assets/humidity.png";
import axios from "axios";
function WeatherApp() {
  const [weatherData, setWeatherData] = useState(null);
  const [image,setImage]=useState(null);
  const search = async () => {
    const cityName = document.querySelector(".cityInput").value;
    
    try {
      const response = await axios.get(
        `http://localhost:8080/weather?city=${cityName}`
      );
      setWeatherData(response.data);

      // Here, update your React component's state with the received data
      // For this example, I'll console log it:
      console.log(weatherData);

      if(weatherData.description=="Clouds"){
        setImage(cloud_icon);
      }
      else if(weatherData.description=="Clear"){
        setImage(clear_icon);
      }
      else if(weatherData.description=="Drizzle"){
        setImage(drizzle_icon);
      }

      else if(weatherData.description=="Rain"){
        setImage(rain_icon);
      }

      else if(weatherData.description=="Snow"){
        setImage(snow_icon);
      }

    } catch (error) {
      console.error("Error fetching weather data:", error);
    }
  };

  return (
    <div className="container">
      <div className="top-bar">
        <input type="text" className="cityInput" placeholder="cityName" />
        <div className="search-icon" onClick={() => search()}>
          <img src={search_icon} alt="" />
        </div>
      </div>
      {weatherData && (
        <>
          <div className="weather-image">
            <img src={image} alt="image" />
          </div>
          <div className="weather-temp">{weatherData.temperature} °C</div>
          <div className="weather-location">{weatherData.location}</div>
          <div className="data-container">
            <div className="element">
              <img src={humidity_icon} alt="" className="icon" />
              <div className="data">
                <div className="humididty-percentage">
                  {weatherData.humidity}
                </div>
                <div className="text">Humidity</div>
              </div>
            </div>

            <div className="element">
              <img src={wind_icon} alt="" className="icon" />
              <div className="data">
                <div className="humididty-percentage">
                  {weatherData.windSpeed}
                </div>
                <div className="text">WindSpeed</div>
              </div>
            </div>
          </div>
        </>
      )}
    </div>
  );
}

export default WeatherApp;
