package com.gateway.gatwayserver.filters;

import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtFilter{
    private final String Secret_Key = "secdsadasdasdsadsadasdadasdsadadsadasdsadasdasdasdasdasdadadadasdsadsadasdadadadsadasdasdadret";

    public Claims tokenValidation(String token){
        try{
        SecretKey secretKey = Keys.hmacShaKeyFor(Secret_Key.getBytes());
        
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
        
        }catch(Exception e){
            return null;
        }
    }
}
