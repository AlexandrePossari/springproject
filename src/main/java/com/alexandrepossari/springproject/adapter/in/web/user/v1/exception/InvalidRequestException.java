package com.alexandrepossari.springproject.adapter.in.web.user.v1.exception;

import org.springframework.validation.BindingResult;

public class InvalidRequestException extends RuntimeException {

    private final BindingResult bindingResult;

    public InvalidRequestException(BindingResult bindingResult) {
        this.bindingResult = bindingResult;
    }

    public BindingResult getBindingResult() {
        return bindingResult;
    }
}
