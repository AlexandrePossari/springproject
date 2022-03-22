package com.alexandrepossari.springproject.adapter.in.web.post.v1.exception;

public class ErrorResponse {

    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Builder {
        private ErrorResponse errorResponse = new ErrorResponse();

        public Builder code(String code) {
            errorResponse.setCode(code);
            return this;
        }

        public Builder message(String message) {
            errorResponse.setMessage(message);
            return this;
        }

        public ErrorResponse build() {
            return errorResponse;
        }
    }
}
