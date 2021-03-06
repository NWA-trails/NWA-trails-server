package com.teamtwo.trails.Security.JWT;

import com.teamtwo.trails.configuration.AppConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Component
public class TokenProvider {

    private final String secretKey = "uX84NXUbMhbebYFPHHPR2RbsBfj4q5Jq";
    private final long tokenValidityInMilliseconds = 1000 * 604800;
    private final UserDetailsService userDetailsService;

    public TokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + this.tokenValidityInMilliseconds);

        System.out.println("Date now is: " + now.toString() + " Date validity is: " + validity.toString());

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setSubject(username)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS512, this.secretKey)
                .setExpiration(validity).compact();
    }

    public Authentication getAuthentication(String token) {
        String username = Jwts.parser().setSigningKey(this.secretKey).parseClaimsJws(token).getBody().getSubject();

        System.out.println("In getAuthentication and username is: " + username.toUpperCase());

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username.toUpperCase());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }


}
