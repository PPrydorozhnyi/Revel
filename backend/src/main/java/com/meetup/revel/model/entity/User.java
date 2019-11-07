package com.meetup.revel.model.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

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

    private String periodicalEmail;

    private Date registerDate;

    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "pinned_event_id")
    @EqualsAndHashCode.Exclude
    private Event pinnedEvent;

    @OneToMany(mappedBy = "user")
    private Set<UserEvent> userEvents;
}
