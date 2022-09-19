package com.example.bcistern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "User")
@Table
public class User //implements UserDetails
        {
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
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    private LocalDateTime last_login;

    private Boolean locked;

    private Boolean enabled;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Inventory> inv;

    public User(String name, String email, String password, double money) {
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
        this.inv = new ArrayList<>();
    }

    public void addToList(Inventory inventory){
        inv.add(inventory);
    }
    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(appUserRole.name());

        return Collections.singletonList(authority);
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
     */
}
