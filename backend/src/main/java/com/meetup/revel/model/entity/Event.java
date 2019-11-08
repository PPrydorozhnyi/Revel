package com.meetup.revel.model.entity;


import com.meetup.revel.entity.EventPeriodicity;
import com.meetup.revel.model.enums.EventType;
import com.meetup.revel.model.type.PostgresEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rv_event")
@TypeDef(name = "pg_enum", typeClass = PostgresEnumType.class)
public class Event {

    @Id
    @Column(name = "event_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    private Date eventDate;

    @Size(max = 1023)
    private String description;

    @Enumerated(EnumType.STRING)
    private EventPeriodicity periodicity;

    @Size(min = 4, max = 100)
    private String place;

    @Enumerated(EnumType.STRING)
    private EventType eventType;

    private boolean isDraft;

    @NotNull
    private int folderId;
    private String imageFilepath;

    //TODO remove this logic. load owner by separate rest call
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User owner;
//    private int ownerId;

    @OneToMany(mappedBy = "event")
    private Set<UserEvent> participants;
}
