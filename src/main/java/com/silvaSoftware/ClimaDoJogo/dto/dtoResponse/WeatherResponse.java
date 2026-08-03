package com.silvaSoftware.ClimaDoJogo.dto.dtoResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.List;

public record WeatherResponse(
        Hourly hourly
) {

    public record Hourly(
            List<LocalDateTime> time,
            @JsonProperty("temperature_2m")
            List<Double> temperature_2m,
            @JsonProperty("precipitation_probability")
            List<Double> precipitationProbability
    ) {}
}
