package com.example.bcistern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    private Long id;
    private Long userId;
    private Long courseId;
    private int rate;
    private String comment;

    public Review(Long userId, Long courseId, int rate, String comment) {
        this.userId = userId;
        this.courseId = courseId;
        this.rate = rate;
        this.comment = comment;
    }
}
