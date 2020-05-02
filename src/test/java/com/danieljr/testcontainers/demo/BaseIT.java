package com.danieljr.testcontainers.demo;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.web.server.LocalServerPort;

import io.restassured.RestAssured;
import lombok.extern.java.Log;

@Log
public abstract class BaseIT {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/api";
        RestAssured.port = this.port;
    }

    enum Resources {
        V1_CUSTOMERS_ENDPOINT("/v1/customers");

        private final String endpoint;

        Resources(String endpoint) {
            this.endpoint = endpoint;
        }

        public String build() {
            return endpoint;
        }
    }
}
