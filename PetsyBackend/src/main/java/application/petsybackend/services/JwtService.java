package application.petsybackend.services;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private static final String SECRET_KEY = "my-very-secret-key-my-very-secret-key";
    private static final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String createJwt(Long id, String role, String email) {
        return Jwts.builder()
                .claim("id",id.toString()) // id user
                .claim("role", role)
                .claim("email",email)
                .setIssuedAt(new Date())  // Data wystawienia tokena
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // Ważność tokena (1 godzina)
                .signWith(key)
                .compact();  // Wygenerowanie tokena
    }


    public Claims decodeJwt(String jwt) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt)// Parsowanie i weryfikacja
                    .getBody();  // Pobranie claimów z tokena
        } catch (JwtException e) {
            throw new IllegalArgumentException("Nieprawidłowy token!", e);
        }
    }

    public boolean isJwtTokenValid(String jwt) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwt);
            return true;
        } catch (JwtException e) {
            System.out.println("Niepoprawny token: " + e.getMessage());
            return false;
        }
    }


    public String getClaim(String jwt, String claimKey) {
        Claims claims = decodeJwt(jwt);
        return claims.get(claimKey, String.class);
    }


    public boolean checkClaim(String jwt, String claimKey, String expectedValue) {
        String claimValue = getClaim(jwt, claimKey);
        return claimValue != null && claimValue.equals(expectedValue);
    }


}
