package com.teamtwo.trails.Security;

import com.teamtwo.trails.Security.JWT.JWTConfigurer;
import com.teamtwo.trails.Security.JWT.TokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                    .disable()
                .cors()
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                    .httpBasic()
                        .and()
                .authorizeRequests()
                /*
                .antMatchers("/pointofinterest/add").hasAnyRole("USER", "ADMIN")
                .antMatchers("/pointofinterest/**").hasRole("ADMIN")
                .antMatchers("/trailcondition/add").hasAnyRole("USER", "ADMIN")
                .antMatchers("/trailcondition/**").hasRole("ADMIN")
                .antMatchers("/user/login").permitAll()
                .antMatchers("/user/validate").permitAll()
                .antMatchers("/user/makeAdminById").hasRole("ADMIN")
                .antMatchers("/user/revokeAdminById").hasRole("ADMIN")
                .antMatchers("/user/deleteById").hasRole("ADMIN")
                */
                .anyRequest().permitAll()
                    .and()
                .apply(new JWTConfigurer(this.tokenProvider));

    }


}
