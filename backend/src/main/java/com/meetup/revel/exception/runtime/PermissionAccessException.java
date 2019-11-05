package com.meetup.revel.exception.runtime;

public class PermissionAccessException extends RuntimeException {
    public PermissionAccessException(String message) {
        super(message);
    }
}
