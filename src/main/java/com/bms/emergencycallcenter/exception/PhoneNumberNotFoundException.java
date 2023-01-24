package com.bms.emergencycallcenter.exception;

public class PhoneNumberNotFoundException extends RuntimeException{
    public PhoneNumberNotFoundException(String message) {
        super(message);
    }
}
