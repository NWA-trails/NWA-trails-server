package com.teamtwo.trails.Security;

import com.teamtwo.trails.Security.JWT.JWTConfigurer;
import com.teamtwo.trails.Security.JWT.TokenProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
        
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final TokenProvider tokenProvider;

    public SecurityConfig(TokenProvider tokenProvider) {
        this.tokenProvider = tokenProvider;
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
                .disable()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
            .antMatchers("/user/signup").permitAll()
            .antMatchers("/user/login").permitAll()
            .antMatchers("/user/**").permitAll()
            .antMatchers("/user/image").permitAll()
            .antMatchers("/user/test").permitAll()
            .antMatchers("/accountInformation/**").permitAll()
            .antMatchers("/emergencycontact/**").permitAll()
            .antMatchers("/pointofinterest/**").permitAll()
            .antMatchers("/trailcondition/**").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(new JWTConfigurer(this.tokenProvider));
    }
}