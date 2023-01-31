package com.yusufislamdemir.weatherapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {

    // if a LocationNotFound error is thrown I returned a response entity object
    @ExceptionHandler(LocationNotFoundException.class)
    public ResponseEntity<?> LocationNotFoundExceptionHandler(LocationNotFoundException locationNotFoundException) {
        return new ResponseEntity<>(locationNotFoundException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // if a IllegalArgument error is thrown ı returned a response entity object
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> FoundExceptionHandler(IllegalArgumentException illegalArgumentException) {
        return new ResponseEntity<>(illegalArgumentException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
