package com.meetup.revel.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "rv_item_comment")
public class CommentItem {

    @Id
    @Column(name = "comment_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    @EqualsAndHashCode.Exclude
    private Item item;

    @Length(max = 2000)
    @Column(name = "body_text", nullable = false)
    private String text;

    @Column(name = "post_time", nullable = false)
    private Date createdWhen;

}
