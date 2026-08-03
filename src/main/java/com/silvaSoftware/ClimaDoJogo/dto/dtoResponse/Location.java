package com.silvaSoftware.ClimaDoJogo.dto.dtoResponse;

public record Location(
        double latitude,
        double longitude,
        String timezone
) {
}
