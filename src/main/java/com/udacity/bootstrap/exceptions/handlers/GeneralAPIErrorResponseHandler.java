package com.udacity.bootstrap.exceptions.handlers;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;

import com.udacity.bootstrap.exceptions.BadRequestException;
import com.udacity.bootstrap.responses.general.GeneralErrorResponse;

@ControllerAdvice
public class GeneralAPIErrorResponseHandler {
    
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<GeneralErrorResponse> handleBadRequestException(BadRequestException ex) {
        GeneralErrorResponse errorResponse = new GeneralErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setError(ex.getData());
        errorResponse.setStatus(false);
        return new ResponseEntity<GeneralErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GeneralErrorResponse> handleNotFoundException(Exception ex) {
        GeneralErrorResponse errorResponse = new GeneralErrorResponse(
            false, ex.getMessage(), ex.getCause().toString(), 0
        );
        return new ResponseEntity<GeneralErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<GeneralErrorResponse> handleAPIServerError(Exception ex) {
        GeneralErrorResponse errorResponse = new GeneralErrorResponse(
            false, ex.getMessage(), ex.getCause().toString(), 0
        );
        return new ResponseEntity<GeneralErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralErrorResponse> handleException(Exception ex) {
        GeneralErrorResponse errorResponse = new GeneralErrorResponse(
            false, ex.getMessage(), ex.getCause().toString(), 0
        );
        return new ResponseEntity<GeneralErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
