package com.laiszig.abc_telecom_service.commons;

public class ItemAlreadyExistsException extends RuntimeException{

    public ItemAlreadyExistsException(String message) {
        super(message);
    }
}
