package com.alexandrepossari.springproject.application.exception;

public enum ErrorReason {

    INVALID_EMAIL("R001", "Email invalid"),
    INVALID_PASSWORD("R002", "Password invalid"),
    INVALID_NAME("R003", "Name invalid"),
    INVALID_CONTENT("R004", "Content invalid"),
    INVALID_USER_ID("R005", "User id invalid"),

    USER_NOT_FOUND("U001", "User not found"),
    USER_EMAIL_ALREADY_REGISTERED("U002", "User email already registered"),

    POST_NOT_FOUND("P001", "Post not found");

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
