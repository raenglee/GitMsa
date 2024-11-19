package com.green.userservice.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JwtUtils {
    private final Environment environment;

    private String SECRET_KEY;
    private SecretKey secretKey = null;
    private int accessTokenExpirationTime;
    private int refreshTokenExpirationTime;

    @Autowired
    public JwtUtils(Environment environment) {
        this.environment = environment;;
        this.SECRET_KEY = this.environment.getProperty("token.secret");
        this.accessTokenExpirationTime =
                Integer.parseInt(this.environment.getProperty("token.access_token_expiration_time"));
        this.refreshTokenExpirationTime =
                Integer.parseInt(this.environment.getProperty("token.refresh_token_expiration_time"));
        this.secretKey =
                new SecretKeySpec(
                    Base64.getEncoder().encode( SECRET_KEY.getBytes() ),
                    SignatureAlgorithm.HS256.getJcaName()
                );
    }

    public String createAccessToken(String email,String userId){
        String jwt = Jwts.builder()
                .claim("email",email)
                .claim("role","USER")
                .claim("userId",userId)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+this.accessTokenExpirationTime))
                .signWith(secretKey)
                .compact();
        return jwt;
    }

    public String createRefreshToken(String email){
        String jwt = Jwts.builder()
                .claim("email",email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+this.refreshTokenExpirationTime))
                .signWith(secretKey)
                .compact();
        return jwt;
    }

}
