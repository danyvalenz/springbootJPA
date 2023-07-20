package com.platzi.platzi.pizzeria.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        //Codigo deprecado
        /*
        http
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

                */
        /*
        http

                .authorizeHttpRequests(customizeRequest ->
                {
                   customizeRequest
                           .anyRequest()
                           .authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return  http.build();*/

        http.authorizeHttpRequests(customRequest -> customRequest
                        .requestMatchers(HttpMethod.GET,"/api/**").permitAll()
                        .requestMatchers(HttpMethod.PUT).denyAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults());

        return http.build();
    }
}
