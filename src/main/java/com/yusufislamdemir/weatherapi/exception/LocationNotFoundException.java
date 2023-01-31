package com.yusufislamdemir.weatherapi.exception;

public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(String message) {
        super(message);
    }
}
