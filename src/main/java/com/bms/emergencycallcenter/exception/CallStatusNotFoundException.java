package com.bms.emergencycallcenter.exception;

public class CallStatusNotFoundException extends RuntimeException{
    public CallStatusNotFoundException(String message) {
        super(message);
    }
}
