package com.example.BITA75;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class config {

    @Bean
    public SecurityFilterChain permitAllSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Crucial for Postman POST requests
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Unlocks EVERY single URL
                );
        return http.build();
    }
}


