package com.meetup.revel.model.entity;


import com.meetup.revel.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "rv_user_event",
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "event_id"})
)
public class UserEvent implements Serializable {

    @Id
    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User user;

    @Id
    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Event event;

    @Enumerated(EnumType.STRING)
    private Role role;

}
