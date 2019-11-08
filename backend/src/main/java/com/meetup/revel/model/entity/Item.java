package com.meetup.revel.model.entity;

import com.meetup.revel.model.enums.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rv_item")
public class Item {

    @Id
    @Column(name = "item_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @Size(max = 1023)
    private String description;

    private String imageFilepath;

    @Length(max = 200)
    private String link;

    private Date dueDate;

    private Integer likes;

    //TODO implement
//    @ManyToMany(targetEntity = String.class)
//    @JoinTable(name="rv_tag_item",
//            joinColumns=@JoinColumn(name="item_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id")
//    )
//    private List<String> tags;

    //TODO same thing as Event dependencies
//    @ManyToOne(optional = false)
//    private int ownerId;
//
//    private int bookerId;

    private Priority priority;

    //TODO find out: what the hell this is doing here
//    private boolean isLike;
}
