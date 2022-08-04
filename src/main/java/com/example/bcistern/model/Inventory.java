package com.example.bcistern.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Inventory {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;
    private Long user_id;
    private Long course_id;
    private LocalDateTime date_added;

    public Inventory(Long user_id, Long course_id, LocalDateTime date_added) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.date_added = date_added;
    }
}
