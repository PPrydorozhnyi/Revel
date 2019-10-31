package com.meetup.meetup.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rv_user")
public class User {

    @Id
    @Column(name = "user_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Pattern(regexp = "^[_.@A-Za-z0-9-]*$")
    @Size(min = 4, max = 50)
    private String login;

    private String password;

    @NotBlank
    @Email
    @Size(min = 5, max = 100)
    private String email;

    @NotBlank
    @Size(min = 4, max = 254)
    private String name;

    @NotBlank
    @Size(min = 4, max = 254)
    private String lastName;

    private String phone;

    private String birthday;

    private Integer timeZone;

    @Column(name = "image_filepath")
    private String imgPath;

    private int pinedEventId;

    private String periodicalEmail;

//    private String pinedEventName;
//    private String pinedEventDate;

    private Date registerDate;
}
