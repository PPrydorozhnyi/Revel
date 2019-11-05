package com.meetup.revel.exception.runtime.frontend.detailed;


public class EmailAlreadyUsedException extends FrontendDetailedException {
    public EmailAlreadyUsedException(String message) {
        super(message);
    }
}
