package com.meetup.revel.security.authorization;

import com.meetup.revel.security.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WishListAuthorization extends AbstractAuthorization {

    @Autowired
    public WishListAuthorization(AuthenticationFacade authenticationFacade) {
        super(authenticationFacade);
    }

}
