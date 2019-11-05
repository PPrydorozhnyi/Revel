package com.meetup.revel.exception.runtime;

public class SecretKeyNotFoundException extends CustomRuntimeException {

    public SecretKeyNotFoundException(String message) {
        super(message);
    }

}
