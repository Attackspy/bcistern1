package com.example.bcistern.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ReviewKey implements java.io.Serializable{
    @Column(name = "user_id")
    Long userId;

    @Column(name = "course_id")
    Long courseId;
}
