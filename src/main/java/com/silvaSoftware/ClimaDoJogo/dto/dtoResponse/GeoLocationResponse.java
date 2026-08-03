package com.silvaSoftware.ClimaDoJogo.dto.dtoResponse;

import java.util.List;

public record GeoLocationResponse(
        List<Result> results
) {
    public record Result(
            double latitude,
            double longitude,
            String timezone
    ) {}
}
