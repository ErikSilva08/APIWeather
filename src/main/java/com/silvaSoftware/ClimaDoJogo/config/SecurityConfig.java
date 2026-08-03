package com.silvaSoftware.ClimaDoJogo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain filter(HttpSecurity http) throws Exception{
        http.csrf(c -> c.disable())
                .authorizeHttpRequests(a -> a.requestMatchers(
                        "/weather/**").permitAll()
                        .anyRequest().authenticated());
        return http.build();
    }
}
