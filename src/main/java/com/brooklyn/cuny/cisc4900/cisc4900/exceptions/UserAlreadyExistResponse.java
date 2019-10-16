package com.brooklyn.cuny.cisc4900.cisc4900.exceptions;

public class UserAlreadyExistResponse {
    private String message;

    public UserAlreadyExistResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
