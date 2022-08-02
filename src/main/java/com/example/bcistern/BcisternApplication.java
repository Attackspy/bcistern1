package com.example.bcistern;

import com.example.bcistern.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
public class BcisternApplication {

	public static void main(String[] args) {
		SpringApplication.run(BcisternApplication.class, args);
	}

}
