package com.yusufislamdemir.weatherapi.exception;


import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        return (
                httpResponse.getStatusCode().series() == CLIENT_ERROR
                        || httpResponse.getStatusCode().series() == SERVER_ERROR);
    }
    //If there is a badrequest error from the API we use, I smashed the default in the restTemplate's errorHandler
    // and formatted the error by putting our own errorhandler to catch it.
    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {

        if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
        } else if (httpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            if (httpResponse.getStatusCode() == HttpStatus.BAD_REQUEST) {
                String errorMessage = IOUtils.toString(httpResponse.getBody(), StandardCharsets.UTF_8);;
                throw new LocationNotFoundException(errorMessage);
            }
        }
    }
}
