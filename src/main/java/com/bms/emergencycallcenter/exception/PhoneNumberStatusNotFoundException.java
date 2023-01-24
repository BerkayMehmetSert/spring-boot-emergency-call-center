package com.bms.emergencycallcenter.exception;

public class PhoneNumberStatusNotFoundException extends RuntimeException{
    public PhoneNumberStatusNotFoundException(String message) {
        super(message);
    }
}
