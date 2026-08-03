package com.silvaSoftware.ClimaDoJogo.dto.dtoRequest;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record MatchWeatherRequest(
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotNull
        LocalDateTime startDateTime,
        @Positive
        int durationMinutes
) {
}
