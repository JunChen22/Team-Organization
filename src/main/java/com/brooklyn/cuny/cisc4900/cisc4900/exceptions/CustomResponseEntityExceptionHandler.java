package com.brooklyn.cuny.cisc4900.cisc4900.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public final ResponseEntity<Object> handleShiftIdException(ShiftIdException ex, WebRequest request) {
        ShiftIdResponse exceptionResponse = new ShiftIdResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleUsernameExistException(UserAlreadyExistException ex, WebRequest request) {
        UserAlreadyExistResponse exceptionResponse = new UserAlreadyExistResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleOrgNameExistException(OrganizationAlreadyExistException ex, WebRequest request) {
        OrganizationAlreadyExistResponse exceptionResponse = new OrganizationAlreadyExistResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
