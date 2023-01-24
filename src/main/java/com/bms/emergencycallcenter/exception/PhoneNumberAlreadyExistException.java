package com.bms.emergencycallcenter.exception;

public class PhoneNumberAlreadyExistException extends RuntimeException{
    public PhoneNumberAlreadyExistException(String message) {
        super(message);
    }
}
