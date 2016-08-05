package com.shootr.db;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RethinkDBConfiguration {
    // connect to docker
    public static final String DBHOST = "rethinkdb";

    @Bean
    public RethinkDBConnectionFactory connectionFactory() {
        return new RethinkDBConnectionFactory(DBHOST);
    }

    @Bean
    DbInitializer dbInitializer() {
        return new DbInitializer();
    }
}
