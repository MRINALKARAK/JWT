package com.jwt.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private String SECRET_KEY = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())   // Use the correct method to set the signing key
                .build()
                .parseClaimsJws(token)            // Parses the token and verifies it
                .getBody();                       // Extracts the claims (payload) from the token
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)                // Correct method for setting claims
                .setSubject(subject)              // Correct method for subject
                .setHeaderParam("typ", "JWT")     // Set JWT type in header
                .setIssuedAt(new Date(System.currentTimeMillis()))  // Set issued date
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 50))  // 50 minutes expiration time
                .signWith(getSigningKey())        // Signing key method
                .compact();                       // Build the token
    }


    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }


}
