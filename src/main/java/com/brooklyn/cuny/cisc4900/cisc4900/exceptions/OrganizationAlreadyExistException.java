package com.brooklyn.cuny.cisc4900.cisc4900.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrganizationAlreadyExistException extends RuntimeException {
    public OrganizationAlreadyExistException(String message) {
        super(message);
    }
}
