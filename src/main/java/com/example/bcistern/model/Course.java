package com.example.bcistern.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table
public class Course {
    @Id
    @SequenceGenerator(
            name = "course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long id;
    private String name;
    private Long owner_id;
    private double price;
    private boolean is_active;

    public Course() {
    }

    public Course(Long id, String name, Long ownerId, double price, boolean isActive) {
        this.id = id;
        this.name = name;
        this.owner_id = owner_id;
        this.price = price;
        this.is_active = is_active;
    }

    public Course(String name, Long ownerId, double price, boolean isActive) {
        this.name = name;
        this.owner_id = owner_id;
        this.price = price;
        this.is_active = is_active;
    }
}
