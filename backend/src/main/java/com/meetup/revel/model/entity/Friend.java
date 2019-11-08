package com.meetup.revel.model.entity;


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
        name = "rv_friend",
        uniqueConstraints = @UniqueConstraint(columnNames = {"sender_id", "receiver_id"})
)
public class Friend implements Serializable {

    @Id
    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sender_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User sender;

    @Id
    @NotNull
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "receiver_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User reciever;

    @NotNull
    private Boolean confirmed = false;

}
