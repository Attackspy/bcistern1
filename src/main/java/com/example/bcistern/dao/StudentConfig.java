package com.example.bcistern.dao;

import com.example.bcistern.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository){
        return args -> {
            User a = new User("asd", "asd", "asd", 0);
            repository.save(a);
        };
    }
}
