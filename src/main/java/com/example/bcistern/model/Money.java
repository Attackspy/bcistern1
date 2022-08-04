package com.example.bcistern.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Money {
    private double amount;
    private Long userId;
}
