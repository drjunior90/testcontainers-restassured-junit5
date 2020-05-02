package com.danieljr.testcontainers.demo.testdata;

import com.danieljr.testcontainers.demo.dto.Customer;

public class TestData {
    public static final String FIRST_NAME = "Daniel";
    public static final String LAST_NAME = "Junior";
    public static final int AGE = 18;

    public static Customer createCustomer() {
        return Customer.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .age(AGE)
                .build();
    }
}
