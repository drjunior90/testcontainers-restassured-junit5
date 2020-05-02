package com.danieljr.testcontainers.demo.repository;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Document(collection = "Customer")
@AllArgsConstructor
@Builder
@Getter
public class CustomerDbModel {
    @Id
    private String _id;
    private String firstName;
    private String lastName;
    private int age;
}
