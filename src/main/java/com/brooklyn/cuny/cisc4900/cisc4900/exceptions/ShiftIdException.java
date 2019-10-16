package com.brooklyn.cuny.cisc4900.cisc4900.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ShiftIdException extends RuntimeException {

    public ShiftIdException(String message) {
        super(message);
    }
}
