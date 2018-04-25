package com.teamtwo.trails.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class ApplicationConfiguration {

    private String secretKey;
    private long tokenValidityInSeconds;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    @Qualifier("secret_key")
    public String getSecretKey() {
        return "random_key_hello";
    }
 
    @Bean
    @Qualifier("token_validity")
    public long getTokenValidityInSeconds() {
        return 2592000;
    }
}
