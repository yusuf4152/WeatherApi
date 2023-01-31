package com.yusufislamdemir.weatherapi.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusufislamdemir.weatherapi.entity.Weather;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    @Value("${apikey}")
    private String apiKey;

    @Value("${baseUrl}")
    private String baseUrl;
    private String baseCountryCode;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    // I checked whether the cityName and country parameters are blank or empty.
    //I made the countryCode variable an optional parameter. if it uses this variable,
    // if its value is not used, I assigned an empty string so that only city information can be searched.
    private void checkCityNameAndCountryCode(String cityName, String countryCode) {
        if (countryCode != null) {
            if (cityName.isEmpty() || cityName.isBlank() || countryCode.isEmpty() || countryCode.isBlank()) {
                baseCountryCode = "," + countryCode;
                throw new IllegalArgumentException("cityName and countryCode must be not blank");
            }
        }
        baseCountryCode = "";
    }

    //get oneDay Weather
    public Weather WeatherOneDay(String cityName, String countryCode) {
        checkCityNameAndCountryCode(cityName, countryCode);
        return restTemplate
                .getForObject(String.format("%s/forecast.json?key=%s&q=%s%s&days=1", baseUrl, apiKey, cityName, baseCountryCode), Weather.class);
    }

    // get oneWeek Weather
    public Weather WeatherOneWeek(String cityName, String countryCode) {
        checkCityNameAndCountryCode(cityName, countryCode);
        return restTemplate
                .getForObject(String.format("%s/forecast.json?key=%s&q=%s%s&days=7", baseUrl, apiKey, cityName, baseCountryCode), Weather.class);
    }

    // get oneMonthWeather
    public Weather WeatherOneMonth(String cityName, String countryCode) {
        checkCityNameAndCountryCode(cityName, countryCode);
        return restTemplate
                .getForObject(String.format("%s/forecast.json?key=%s&q=%s%s&days=15", baseUrl, apiKey, cityName, baseCountryCode), Weather.class);
    }
}
