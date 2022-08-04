package com.example.bcistern.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Review {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;
    private Long user_id;
    private Long course_id;
    private int rating;
    private String comment;

    public Review(Long userId, Long courseId, int rate, String comment) {
        this.user_id = userId;
        this.course_id = courseId;
        this.rating = rate;
        this.comment = comment;
    }
}
