package com.example.bcistern.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Table
@Entity
@ToString
public class Inventory {

    @EmbeddedId
    private InventoryKey id = new InventoryKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    private LocalDateTime date_added;

    public Inventory(InventoryKey id, User user, Course course, LocalDateTime date_added) {
        super();
        this.id = id;
        this.user = user;
        this.course = course;
        this.date_added = date_added;
    }
}
