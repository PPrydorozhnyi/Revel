package com.meetup.revel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rv_message")
public class Message {

    @Id
    @Column(name = "message_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User user;

    @NotBlank
    @NotNull
    @Length(max = 250)
    private String text;

    @Column(name = "message_date")
    private Date createdWhen;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

}
