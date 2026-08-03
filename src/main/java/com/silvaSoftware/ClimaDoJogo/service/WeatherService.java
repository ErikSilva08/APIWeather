package com.silvaSoftware.ClimaDoJogo.service;

import com.silvaSoftware.ClimaDoJogo.config.WeatherClient;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.Location;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherResponse getWeather(Location location, LocalDateTime startHour, LocalDateTime endHour) {
        return weatherClient.getWeather(location.latitude(), location.longitude(), location.timezone(), startHour, endHour);
    }
}
