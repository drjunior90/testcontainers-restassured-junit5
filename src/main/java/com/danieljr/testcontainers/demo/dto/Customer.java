package com.danieljr.testcontainers.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Customer {
    private final String customerId;
    private final String firstName;
    private final String lastName;
    private final int age;
}
