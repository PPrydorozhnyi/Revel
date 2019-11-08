package com.meetup.revel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "rv_tag")
public class Tag {

    @Id
    @Column(name = "tag_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Length(min = 1, max = 20)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinTable(
            name = "rv_tag_item",
            joinColumns = @JoinColumn(name = "tag_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    @EqualsAndHashCode.Exclude
    private Set<Item> items;
}
