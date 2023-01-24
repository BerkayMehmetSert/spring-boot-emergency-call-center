package com.bms.emergencycallcenter.exception;

public class ActionNotFoundException extends RuntimeException{
    public ActionNotFoundException(String message) {
        super(message);
    }
}
