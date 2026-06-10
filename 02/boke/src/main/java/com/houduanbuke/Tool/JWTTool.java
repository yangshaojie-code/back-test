package com.houduanbuke.Tool;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JWTTool {

    private static String key="ysjweb";
    public static String generateJwt(Map<String,Object> claims){
       String jwt= Jwts.builder()
               .signWith(SignatureAlgorithm.HS256,key)
               .setClaims(claims)
               .compact();
       return jwt;
    }
    public static Claims parseJwt(String jwt){
       Claims info=Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
       return info;
    }
}
