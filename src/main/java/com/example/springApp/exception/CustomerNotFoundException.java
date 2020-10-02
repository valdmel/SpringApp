package com.example.springApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(Long id) {
        super("Customer with id = " + id + " was not found!");
    }

    public CustomerNotFoundException(String firstName, String lastName) {
        super("Customer " + firstName + " " + lastName + " does not exists!");
    }
}