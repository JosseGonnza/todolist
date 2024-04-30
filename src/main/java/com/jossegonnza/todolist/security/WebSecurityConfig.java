package com.jossegonnza.todolist.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request) -> request
                        .requestMatchers("/categories/**", "/tasks/**").authenticated()
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/index")
                        .permitAll()
                        .defaultSuccessUrl("/access")
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
