package com.alexandrepossari.springproject.adapter.in.web.post.v1.exception;


import com.alexandrepossari.springproject.application.exception.EntityAlreadyRegisteredException;
import com.alexandrepossari.springproject.application.exception.EntityNotFoundException;
import com.alexandrepossari.springproject.application.exception.ErrorReason;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@ControllerAdvice
public class PostControllerAdvice {

    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<List<ErrorResponse>> handle(InvalidRequestException ex) {
        return ResponseEntity
                .status(BAD_REQUEST)
                .body(buildErrorResponseList(ex.getBindingResult()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<List<ErrorResponse>> handle(EntityNotFoundException ex) {
        return ResponseEntity
                .status(NOT_FOUND)
                .body(buildErrorResponseList(ex.getErrorReason()));
    }

    @ExceptionHandler(EntityAlreadyRegisteredException.class)
    public ResponseEntity<List<ErrorResponse>> handle(EntityAlreadyRegisteredException ex) {
        return ResponseEntity
                .status(CONFLICT)
                .body(buildErrorResponseList(ex.getErrorReason()));
    }

    private List<ErrorResponse> buildErrorResponseList(ErrorReason errorReason) {
        return List.of(
                new ErrorResponse.Builder()
                        .code(errorReason.getCode())
                        .message(errorReason.getMessage())
                        .build()
        );
    }

    private List<ErrorResponse> buildErrorResponseList(BindingResult bindingResult) {
        return bindingResult.getAllErrors()
                .stream()
                .map(e -> new ErrorResponse.Builder()
                        .code(e.getCode())
                        .message(e.getDefaultMessage())
                        .build())
                .collect(Collectors.toList());
    }
}

