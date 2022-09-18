package com.example.took_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@EnableCaching
@ConfigurationPropertiesScan
public class TookBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(TookBackendApplication.class, args);
    }

}
