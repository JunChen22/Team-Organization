package com.brooklyn.cuny.cisc4900.cisc4900.exceptions.Organization;

public class EmployeeFormResponse {

    private String message;

    public EmployeeFormResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
