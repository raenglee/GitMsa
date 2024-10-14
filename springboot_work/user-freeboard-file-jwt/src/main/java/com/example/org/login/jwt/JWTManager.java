package com.example.org.login.jwt;

import com.example.org.error.JWTAuthException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JWTManager {

    private final Environment environment;

    // JWT 생성
    public String createJWT(String email,String role){
        String secrekey = environment.getProperty("spring.jwt.secret");
        String jwt = Jwts.builder()
                .claim("email",email)
                .claim("role",role)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
//                .expiration(new Date(System.currentTimeMillis() + 1000)) // 1초 지나면 유효시간 없음...
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(secrekey.getBytes()))
                .compact();
        return jwt;
    }

    public Jws<Claims> getClaims(String jwt){
        String secrekey = environment.getProperty("spring.jwt.secret");
        try {
            // 비밀번호 설정
            SecretKey secretKey
                    = new SecretKeySpec(secrekey.getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());

            // 해당비밀번호로 jwt 토큰 복호화 해서 claims 가져오기
            Jws<Claims> cliams = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);

            return cliams;
        }catch (Exception e){
            throw new JWTAuthException("JWT TOKEN 문제 = "+e.getMessage());
        }
    }
}