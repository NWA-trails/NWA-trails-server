package com.teamtwo.trails.Security.JWT;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final TokenProvider tokenProvider;

    public JWTConfigurer(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        JWTFilter customFilter = new JWTFilter(this.tokenProvider);
        httpSecurity.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
