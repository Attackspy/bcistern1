package com.example.bcistern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class InventoryKey implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Column(name = "user_id")
    Long userId;

    @Column(name = "course_id")
    Long courseId;
}
