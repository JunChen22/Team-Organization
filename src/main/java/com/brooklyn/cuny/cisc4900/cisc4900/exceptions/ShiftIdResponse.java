package com.brooklyn.cuny.cisc4900.cisc4900.exceptions;

public class ShiftIdResponse {

    private String idNotFound;

    public ShiftIdResponse(String idNotFound) {
        this.idNotFound = idNotFound;
    }

    public String getIdNotFound() {
        return idNotFound;
    }

    public void setIdNotFound(String idNotFound) {
        this.idNotFound = idNotFound;
    }
}
