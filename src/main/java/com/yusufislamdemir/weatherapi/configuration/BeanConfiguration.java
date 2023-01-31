package com.yusufislamdemir.weatherapi.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusufislamdemir.weatherapi.exception.RestTemplateResponseErrorHandler;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.annotation.PostConstruct;

@Configuration
public class BeanConfiguration {

    private final RestTemplateResponseErrorHandler restTemplateResponseErrorHandler;


    public BeanConfiguration(RestTemplateResponseErrorHandler restTemplateResponseErrorHandler) {
        this.restTemplateResponseErrorHandler = restTemplateResponseErrorHandler;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().errorHandler(restTemplateResponseErrorHandler).build();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
