package com.meetup.revel.model.entity;

import com.meetup.revel.model.enums.Priority;
import com.meetup.revel.model.type.PostgresEnumType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rv_user_item")
@TypeDef(name = "pg_enum", typeClass = PostgresEnumType.class)
public class UserItem implements Serializable {

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "user_id")
    private User owner;

    @Id
    @ManyToOne
    @NotNull
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "id_who_booked")
    private User booker;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private Date dueDate;
}
