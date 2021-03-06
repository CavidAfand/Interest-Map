package az.interestmap.interestmap.service.impl;

import az.interestmap.interestmap.service.TokenManager;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenManagerImpl implements TokenManager {

    Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);

    @Override
    public String generateToken(String sessionId, String username) {
        return Jwts.builder()
                .setSubject(username)
                .setId(sessionId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .signWith(key)
                .compact();
    }

    @Override
    public String getUsername(String token) {
        Claims claims = getClaims(token);
        return claims.getSubject();
    }

    @Override
    public String getSessionId(String token) {
        Claims claims = getClaims(token);
        return claims.getId();
    }

    @Override
    public Map<String, String> getInfoFromToken(String token) {
        Claims claims = getClaims(token);
        Map<String, String> info = new HashMap<>();
        info.put("sessionId", claims.getId());
        info.put("username", claims.getSubject());
        return info;
    }

    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }

}
