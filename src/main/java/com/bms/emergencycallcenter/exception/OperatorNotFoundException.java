package com.bms.emergencycallcenter.exception;

public class OperatorNotFoundException extends RuntimeException{
    public OperatorNotFoundException(String message) {
        super(message);
    }
}
