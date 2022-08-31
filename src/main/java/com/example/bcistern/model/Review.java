package com.example.bcistern.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Review {
/*
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;
 */

    @EmbeddedId
    private ReviewKey reviewKey = new ReviewKey();

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    User user;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;

    private LocalDateTime date_added;
    private int rating;
    private String comment;

    public Review(User user, Course course, LocalDateTime date_added, int rating, String comment) {
        this.user = user;
        this.course = course;
        this.date_added = date_added;
        this.rating = rating;
        this.comment = comment;
    }
}
