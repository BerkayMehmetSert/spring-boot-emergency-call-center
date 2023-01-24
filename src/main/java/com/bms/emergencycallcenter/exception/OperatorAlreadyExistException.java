package com.bms.emergencycallcenter.exception;

public class OperatorAlreadyExistException extends RuntimeException{
    public OperatorAlreadyExistException(String message) {
        super(message);
    }
}
