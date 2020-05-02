package com.danieljr.testcontainers.demo.infrastructure.container;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import lombok.extern.java.Log;

@Log
public class MongoDbExtension implements BeforeAllCallback, AfterAllCallback {

    public static MongoDbContainer mongoDbContainer;

    @Override
    public void beforeAll(ExtensionContext context) {
        mongoDbContainer = new MongoDbContainer();
        log.info("Starting MongoDb Container");
        mongoDbContainer.start();
        System.setProperty("MONGO_DB_HOST", mongoDbContainer.getContainerIpAddress());
        System.setProperty("MONGO_DB_PORT", String.valueOf(mongoDbContainer.getPort()));
        System.setProperty("MONGO_DB_NAME", "MDB");
        log.info("Finished starting MongoDb Container");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        log.info("Stopping MongoDb Container");
        mongoDbContainer.stop();
        System.clearProperty("MONGO_DB_HOST");
        System.clearProperty("MONGO_DB_PORT");
        System.clearProperty("MONGO_DB_NAME");
        log.info("Finished stopping MongoDb Container");
    }
}
