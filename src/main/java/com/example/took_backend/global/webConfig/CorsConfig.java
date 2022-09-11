package com.example.took_backend.global.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedHeaders("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "PATCH", "DELETE", "PUT", "HEAD")
                .maxAge(3000);
    }
}
