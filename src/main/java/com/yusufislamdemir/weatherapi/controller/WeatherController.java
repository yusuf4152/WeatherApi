package com.yusufislamdemir.weatherapi.controller;

import com.yusufislamdemir.weatherapi.entity.Weather;
import com.yusufislamdemir.weatherapi.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {
    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/getForecastOneDay")
    public ResponseEntity<Weather> getForecastOneDay(@RequestParam String cityName, @RequestParam(required = false) String country) {
        return ResponseEntity.status(HttpStatus.FOUND).body(weatherService.WeatherOneDay(cityName, country));
    }

    @GetMapping("/getForecastOneWeek")
    public ResponseEntity<Weather> getForecastOneWeek(@RequestParam String cityName, @RequestParam(required = false) String country) {
        return ResponseEntity.status(HttpStatus.FOUND).body(weatherService.WeatherOneWeek(cityName, country));
    }

    @GetMapping("/getForecastOneMonth")
    public ResponseEntity<Weather> getForecastOneMonth(@RequestParam String cityName, @RequestParam(required = false) String country) {
        return ResponseEntity.status(HttpStatus.FOUND).body(weatherService.WeatherOneMonth(cityName, country));
    }
}
