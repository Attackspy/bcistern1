package com.example.bcistern.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Course {
    private Long id;
    private String name;
    private Long ownerId;
    private double price;
    private boolean isActive;

    public Course() {
    }

    public Course(Long id, String name, Long ownerId, double price, boolean isActive) {
        this.id = id;
        this.name = name;
        this.ownerId = ownerId;
        this.price = price;
        this.isActive = isActive;
    }

    public Course(String name, Long ownerId, double price, boolean isActive) {
        this.name = name;
        this.ownerId = ownerId;
        this.price = price;
        this.isActive = isActive;
    }
}
