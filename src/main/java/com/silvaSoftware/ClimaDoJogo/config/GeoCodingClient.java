package com.silvaSoftware.ClimaDoJogo.config;

import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.GeoLocationResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class GeoCodingClient {

    private final RestClient restClient;

    public GeoCodingClient (@Qualifier("geoRestClient") RestClient restClient) {
        this.restClient = restClient;
    }

    public GeoLocationResponse fingLocation(String city, String state) {
        return restClient.get().uri("?name={city}&count=1&language=pt&countryCode=BR&admin1={state}&feature_code=PPL", city,state)
                .retrieve()
                .body(GeoLocationResponse.class);
    }
}
