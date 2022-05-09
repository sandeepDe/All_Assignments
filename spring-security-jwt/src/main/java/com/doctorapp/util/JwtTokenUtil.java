package com.doctorapp.util;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {
    private  static final long serialVersionUID = -2550185165626007488L;
    public static  final long JWT_TOKEN_VALIDITY = 5*60*60;
    @Value("${jwt.secret")
    private String secret;


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token){
        return getClaimFromToken(token,Claims::getExpiration);
    }
    private <T>T getClaimFromToken(String token, Function<Claims, T> claimsResolver){
        final  Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    private Claims getAllClaimsFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    }
    private Boolean isTokenExpired(String token){
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    //generate token for user
    public String generateToken(UserDetails userDetails){
        Map<String,Object>claims = new HashMap<>();
        return  doGenerateToken(claims,userDetails.getUsername());
    }


    private String doGenerateToken(Map<String,Object>claims,String subject){
        Instant isInstant  = Instant.from(
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
                        .withZone(ZoneId.of("UTC"))
                        .parse("2022-01-01T20:20"));
        Instant exInstant = Instant.from(
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")
                        .withZone(ZoneId.of("UTC"))
                        .parse("2022-12-31T20:20"));
        Date exDate = Date.from(exInstant);
        Date isDate = Date.from(isInstant);
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(isDate)
                .setExpiration(exDate)
                .signWith(SignatureAlgorithm.HS256,secret)
                .compact();
    }
    public Boolean validateToken(String token,UserDetails userDetails){
        final  String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername())&&!isTokenExpired(token));
    }
}
