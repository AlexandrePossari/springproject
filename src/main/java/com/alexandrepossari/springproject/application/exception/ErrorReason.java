package com.alexandrepossari.springproject.application.exception;

public enum ErrorReason {

//    private String email;
//    private String password;
//    private String nome;
//    private long id;

    INVALID_EMAIL("R001", "Email invalid"),
    INVALID_PASSWORD("R002", "Password invalid"),
    INVALID_NAME("R003", "Name invalid"),

    USER_NOT_FOUND("U001", "User not found"),
    USER_EMAIL_ALREADY_REGISTERED("U002", "User email already registered");

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
