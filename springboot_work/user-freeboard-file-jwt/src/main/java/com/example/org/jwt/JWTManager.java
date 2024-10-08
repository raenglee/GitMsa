package com.example.org.jwt;

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

    //JWT 생성
    public String createJWT(String email,String role){
        String secretkey = environment.getProperty("spring.jwt.secret");
        String jwt = Jwts.builder()
                .claim("email",email)
                .claim("role",role)
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
//                .expiration(new Date(System.currentTimeMillis() + 1000)) // 유효시간 1초, 되는지 확인용
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                        Base64.getEncoder().encodeToString(secretkey.getBytes()))
                .compact();
        return jwt;
    }

    //JWT 유효성 검사(비밀번호 포함)
    public String validJWT(String jwt){
        String secretkey = environment.getProperty("spring.jwt.secret");
        try {
            SecretKey secretKey
                    = new SecretKeySpec(secretkey.getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());
            Jws<Claims> claims = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);
            // 만약 유효시간이 지났으면 JWT 사용 못하도록 설정
            claims.getPayload().getExpiration().before(new Date());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "fail";
        }
        return "success";
    }
}
