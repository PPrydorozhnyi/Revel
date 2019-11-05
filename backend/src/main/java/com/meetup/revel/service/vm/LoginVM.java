package com.meetup.revel.service.vm;

import com.meetup.revel.entity.User;
import com.meetup.revel.rest.controller.AccountController;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Used for get {@link User} credentials at
 * {@link AccountController#login(LoginVM)} (LoginVM, HttpServletResponse)}.
 */
@Data
public class LoginVM {
    @NotBlank
    @Size(min = 4, max = 50)
    private String login;

    @Size(min = 6, max = 50)
    private String password;
}
