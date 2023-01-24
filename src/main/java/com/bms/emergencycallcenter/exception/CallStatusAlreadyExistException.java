package com.bms.emergencycallcenter.exception;

public class CallStatusAlreadyExistException extends RuntimeException{
    public CallStatusAlreadyExistException(String message) {
        super(message);
    }
}
