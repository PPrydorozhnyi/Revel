package com.meetup.revel.exception.runtime;

public class BadTokenException extends CustomRuntimeException {
    public BadTokenException(String message) {
        super(message);
    }
}
