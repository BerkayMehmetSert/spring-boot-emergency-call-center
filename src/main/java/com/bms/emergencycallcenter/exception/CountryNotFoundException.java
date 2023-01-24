package com.bms.emergencycallcenter.exception;

public class CountryNotFoundException extends RuntimeException{
    public CountryNotFoundException(String message) {
        super(message);
    }
}
