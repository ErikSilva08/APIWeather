package com.silvaSoftware.ClimaDoJogo.config;

import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.WeatherResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;

@Component
public class WeatherClient {

    private final RestClient restClient;

    public WeatherClient(
            @Qualifier("weatherRestClient") RestClient restClient
    ) {
        this.restClient = restClient;
    }

    public WeatherResponse getWeather(double latitude, double longitude,String timezone, LocalDateTime startHour, LocalDateTime endHour) {
        return restClient.get().uri("?latitude={latitude}&longitude={longitude}&hourly=temperature_2m,precipitation_probability,precipitation,weather_code&timezone={timezone}&start_hour={startHour}&end_hour={endHour}", latitude, longitude,timezone, startHour, endHour)
                .retrieve()
                .body(WeatherResponse.class);
    }

}
