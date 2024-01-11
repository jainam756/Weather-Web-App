# Weather Application

## Overview

This Weather Application provides real-time weather information for cities. The application is built using React for the frontend and Spring Boot for the backend. It employs a caching mechanism to store user-searched cities for 10 minutes, improving performance by fetching data from the database within this timeframe.

## Features

- **Frontend (Weather_frontend):**
  - Developed using React.
  - User-friendly interface for searching and displaying weather information.

- **Backend (Weather_backend):**
  - Built with Spring Boot.
  - Implements caching to store and retrieve city weather data efficiently.
  - Uses Aspect-Oriented Programming (AOP) to measure the time taken for fetching data from the database and calling external APIs.

## Caching Strategy

The application optimizes data retrieval by storing recently searched cities in the database. Within a 10-minute window, subsequent requests for the same city retrieve data from the database. After 10 minutes, or for new city searches, the application fetches data from the OpenWeather API.

## AOP Performance Monitoring

Aspect-Oriented Programming (AOP) is used to measure the time taken for fetching data from the database and calling external APIs. This provides insights into the application's performance and helps identify areas for optimization.

## Setup and Installation

### Prerequisites

- Node.js and npm for frontend development.
- Java and Maven for backend development.
- MySQL or another relational database for data storage.

### Frontend

1. Navigate to the Weather_frontend directory:

    ```bash
    cd Weather_frontend
    ```

2. Install dependencies:

    ```bash
    npm install
    ```

3. Run the application:

    ```bash
    npm run dev
    ```

   Access the frontend application at http://localhost:3000.

### Backend

1. Navigate to the Weather_backend directory:

    ```bash
    cd Weather_backend
    ```

2. Configure your database settings in `application.properties`.

3. Run the Spring Boot application:

    ```bash
    mvn spring-boot:run
    ```

   The backend API will be available at http://localhost:8080.

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests. Your feedback and contributions are welcome!

## License

This project is licensed under the [MIT License](LICENSE).
