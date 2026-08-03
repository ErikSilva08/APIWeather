package com.silvaSoftware.ClimaDoJogo.service;

import com.silvaSoftware.ClimaDoJogo.dto.dtoRequest.MatchWeatherRequest;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.Location;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MatchWeatherService {

    private final GeoCodingService geoCodingService;
    private final WeatherService weatherService;

    public WeatherResponse analyze(MatchWeatherRequest request) {
        LocalDateTime endHour = request.startDateTime().plusMinutes(
                request.durationMinutes()
        );

        Location location = geoCodingService.getLocation(request);

        WeatherResponse weatherResponse = weatherService.getWeather(
                location,
                request.startDateTime(),
                endHour);

        return weatherResponse;
    }
}
