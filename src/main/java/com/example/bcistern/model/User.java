package com.example.bcistern.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity(name = "User")
@Table
public class User {
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private String password;
    private double money;

    private LocalDateTime last_login;

    public User(String name, String email, String password, double money) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
    }

    public User(Long id, String name, String email, String password, double money) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
    }
}
