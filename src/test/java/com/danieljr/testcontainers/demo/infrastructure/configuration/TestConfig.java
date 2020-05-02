package com.danieljr.testcontainers.demo.infrastructure.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.danieljr.testcontainers.demo.TestcontainersDemoApplication;

@Configuration
@Import(TestcontainersDemoApplication.class)
public class TestConfig {
}
