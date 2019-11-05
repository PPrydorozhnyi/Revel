package com.meetup.revel.security;

import com.meetup.revel.entity.User;
import com.meetup.revel.exception.runtime.AuthenticationException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import static com.meetup.revel.keys.Key.EXCEPTION_AUTHENTICATION;

/**
 * Used for get authenticated {@link User}.
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@PropertySource("classpath:strings.properties")
public class AuthenticationFacade {

    private static Logger log = LoggerFactory.getLogger(AuthenticationFacade.class);
    private final Environment env;

    public User getAuthentication() {
        log.debug("Trying to get authentication from SecurityContextHolder");

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            log.error("User is not authenticated");
            throw new AuthenticationException(env.getProperty(EXCEPTION_AUTHENTICATION));
        }

        User authenticatedUser = (User) authentication.getPrincipal();

        log.debug("Found authenticated user '{}'", authenticatedUser);

        return authenticatedUser;
    }
}
