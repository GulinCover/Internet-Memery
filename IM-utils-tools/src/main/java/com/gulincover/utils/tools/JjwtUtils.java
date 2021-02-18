package com.gulincover.utils.tools;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

@Data
public class JjwtUtils {
    @Value("${jwt.signingKey}")
    private String signingKey;
    @Value("${jwt.ttl}")
    private Long ttl;

    public String createJwt(Long userId, String userName, Map<String, Object> map, Date date) {
        Long now = date.getTime();
        Long exp = now + ttl;

        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(String.valueOf(userId))
                .setSubject(userName)
                .setIssuedAt(date)
                .signWith(SignatureAlgorithm.HS256, signingKey)
                .addClaims(map)
                .setExpiration(new Date(exp));
        return jwtBuilder.compact();
    }

    public Claims parseJwt(String token) {
        return Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).getBody();
    }
}
