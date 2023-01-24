package com.bms.emergencycallcenter.exception;

public class PhoneNumberStatusAlreadyExistException extends RuntimeException{
    public PhoneNumberStatusAlreadyExistException(String message) {
        super(message);
    }
}
