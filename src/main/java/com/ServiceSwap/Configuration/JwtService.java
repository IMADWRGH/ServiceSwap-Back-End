package com.ServiceSwap.Configuration;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private static final String SECRET_KEY="E2C11L67BQ7POERU01ZV40H3GTHVF97205ZX8FX2O7B2VNW8IP5TWASEWFIAW2RZPFJJ5FZBTA4AYKLMH0PQBOQARQ50G8LQ3UT3AQNAQLEY986VSPQQ7OREX70RTR613AY7EVIVSZCOSE65MPGU26005ZZ3YR7NM3V9PKTIYZTC1KCAVJD7DENPCEDR4343AU8APX9D42IZJVYKQCI143XWGHI3JOC9NAK74EX60HB9BXVJBXB0RA4BQOG7MN9I";
    public String extractUserEmal(String jwt) {
        return extractClaim(jwt,Claims::getSubject);
    }
    public <T> T extractClaim(String jwt , Function<Claims,T> claimsResolver){
        final Claims claims=extractAllClaims(jwt);
        return claimsResolver.apply(claims);
    }
    public String generateJwt( UserDetails userDetails){
        return generateJwt(new HashMap<>(),userDetails);
    }
    public String generateJwt(Map<String,Object> extractClaims, UserDetails userDetails){
        return Jwts.builder()
                .setClaims(extractClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24)) // jwt valide for 24h
                .signWith(getSignInkey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public boolean isJwtValid(String jwt ,UserDetails userDetails){
        final String userEmail =extractUserEmal(jwt);
        return (userEmail.equals(userDetails.getUsername())) && !isJwtExpired(jwt);
    }

    private boolean isJwtExpired(String jwt) {
        return extractExprition(jwt).before(new Date());
    }

    private Date extractExprition(String jwt) {
        return extractClaim(jwt, Claims::getExpiration);
    }

    private Claims extractAllClaims(String jwt){
        return Jwts.parserBuilder()
                .setSigningKey(getSignInkey())
                .build()
                .parseClaimsJwt(jwt)
                .getBody();
    }

    private Key getSignInkey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
