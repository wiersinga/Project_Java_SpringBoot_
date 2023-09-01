package com.testsring.test.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class LicenseDrivingException extends ResponseStatusException {
    public LicenseDrivingException() {

        super(HttpStatus.NOT_FOUND, "the driving license is not valid !");
    }
}
