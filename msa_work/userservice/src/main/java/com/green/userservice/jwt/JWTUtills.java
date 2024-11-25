package com.green.userservice.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JWTUtills {
    private final Environment environment;

    private String SECRET_KEY;
    private SecretKey secretKey = null;
    private String accessTokenExpirationTime;
    private String refreshTokenExpirationTime;

    public JWTUtills(Environment environment) {
        this.environment = environment;
        this.SECRET_KEY = this.environment.getProperty("token.secret");
        this.accessTokenExpirationTime = this.environment.getProperty("token.access_token_expiration");
        this.refreshTokenExpirationTime = this.environment.getProperty("token.refresh_token_expiration");
        this.secretKey = new SecretKeySpec( Base64.getEncoder().encode( SECRET_KEY.getBytes()),
                SignatureAlgorithm.HS256.getJcaName());
    }

    public String createAccessToken(String email, String userId){
        String jwt = Jwts.builder()
                .claim("email",email)
                .claim("role","USER")
                .claim("userId",userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +this.accessTokenExpirationTime)) // 1초*60*60*24 1일 유효함
                .signWith(secretKey)
                .compact();
        return jwt;
    }

    public String createRefreshToken(String email){
        String jwt = Jwts.builder()
                .claim("email",email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() +this.accessTokenExpirationTime))
                .signWith(secretKey)
                .compact();
        return jwt;
    }


}
