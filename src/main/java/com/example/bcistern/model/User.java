package com.example.bcistern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "user")
    List<Inventory> inv;

    public User(Long id, String name, String email, String password, double money, LocalDateTime last_login) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
        this.inv = new ArrayList<>();
    }

    public User(Long id, String name, String email, String password, double money) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.money = money;
        this.inv = inv;
    }

    public void addToList(Inventory inventory){
        inv.add(inventory);
    }
}
