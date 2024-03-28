package com.auth.authservice.authentication;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtGenerator {
    private final String Secret_Key = "secdsadasdasdsadsadasdadasdsadadsadasdsadasdasdasdasdasdadadadasdsadsadasdadadadsadasdasdadret";

    public JwtGenerator() {}
    
    public String generate(Map<String,String> user) {
        SecretKey secretKey = Keys.hmacShaKeyFor(Secret_Key.getBytes());
        
        return Jwts.builder()
                .claim("role", user.get("role"))
                .claim("id", user.get("id"))
                .expiration(Date.from(Instant.now().plusSeconds(86400)))
                .signWith(secretKey).compact();
    }
    
}
