package com.silvaSoftware.ClimaDoJogo.service;

import com.silvaSoftware.ClimaDoJogo.config.GeoCodingClient;
import com.silvaSoftware.ClimaDoJogo.dto.dtoRequest.MatchWeatherRequest;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.GeoLocationResponse;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.Location;
import com.silvaSoftware.ClimaDoJogo.exceptions.LocationNotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GeoCodingService {

    private final GeoCodingClient geoCodingClient;

    public Location getLocation(MatchWeatherRequest request) {
        GeoLocationResponse response = geoCodingClient.fingLocation(
                request.city(),
                request.state()
        );

        if (response.results().isEmpty()) {
            throw new LocationNotFound("Location not found");
        }

        GeoLocationResponse.Result result = response.results().get(0);

        double latitude = result.latitude();
        double longitude = result.longitude();
        String timezone = result.timezone();

        return new Location(latitude, longitude, timezone);
    }
}
