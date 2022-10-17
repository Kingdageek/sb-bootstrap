package com.udacity.bootstrap.responsehandlers;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import com.udacity.bootstrap.exceptions.BadRequestException;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler {

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return hasClientError(response) || hasServerError(response);
    }

    private boolean hasClientError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR;
    }

    private boolean hasServerError(ClientHttpResponse response) throws IOException {
        return response.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR;
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (hasServerError(response)) {
            throw new HttpServerErrorException(response.getStatusCode(), response.getBody().toString());
        }
        
        if (hasClientError(response)) {
            throw new BadRequestException(false, "Bad request", response.getBody().toString());            
        }
    }
    
}
