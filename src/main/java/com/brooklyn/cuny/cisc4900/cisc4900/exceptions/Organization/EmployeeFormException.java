package com.brooklyn.cuny.cisc4900.cisc4900.exceptions.Organization;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeFormException extends RuntimeException {
    public EmployeeFormException(String message) {
        super(message);
    }
}
