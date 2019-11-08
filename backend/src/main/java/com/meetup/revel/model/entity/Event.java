package com.meetup.revel.model.entity;


import com.meetup.revel.entity.EventPeriodicity;
import com.meetup.revel.model.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "rv_event")
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

    private String imageFilepath;

    //TODO remove this logic. load owner by separate rest call
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User owner;
//    private int ownerId;

    @OneToMany(mappedBy = "event", orphanRemoval = true, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    private Set<UserEvent> participants;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "folder_id")
    @EqualsAndHashCode.Exclude
    private Folder folder;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    private List<Chat> chats;
}
