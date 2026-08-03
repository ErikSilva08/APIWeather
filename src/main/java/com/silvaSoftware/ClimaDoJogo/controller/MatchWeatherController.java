package com.silvaSoftware.ClimaDoJogo.controller;

import com.silvaSoftware.ClimaDoJogo.dto.dtoRequest.MatchWeatherRequest;
import com.silvaSoftware.ClimaDoJogo.dto.dtoResponse.WeatherResponse;
import com.silvaSoftware.ClimaDoJogo.service.MatchWeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class MatchWeatherController {

    private final MatchWeatherService service;

    @PostMapping
    public ResponseEntity<WeatherResponse> analyze(@Valid @RequestBody MatchWeatherRequest request) {
        return ResponseEntity.ok(service.analyze(request));
    }
}
