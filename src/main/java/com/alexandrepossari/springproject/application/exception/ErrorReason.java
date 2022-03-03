package com.alexandrepossari.springproject.application.exception;

public enum ErrorReason {

    USER_NOT_FOUND("U001", "User not found");

    private String code;
    private String message;

    ErrorReason(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
