package com.alexandrepossari.springproject.application.exception;

public class EntityNotFoundException extends RuntimeException {

    private final ErrorReason errorReason;

    public EntityNotFoundException(ErrorReason errorReason) {
        this.errorReason = errorReason;
    }

    public ErrorReason getErrorReason() {
        return errorReason;
    }
}
