package com.alexandrepossari.springproject.application.exception;

public class EntityAlreadyRegisteredException extends RuntimeException {

    private final ErrorReason errorReason;

    public EntityAlreadyRegisteredException(ErrorReason errorReason) {
        this.errorReason = errorReason;
    }

    public ErrorReason getErrorReason() {
        return errorReason;
    }
}
