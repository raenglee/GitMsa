package com.pmh.org.jwt;

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
    public String createJWT(String secretkey){
        String jwt = Jwts.builder()
                .claim("email","aaa@naver.com")
                .claim("role","ADMIN")
                .issuedAt(new Date(System.currentTimeMillis())) // 현재 시간 넣기
//                .expiration(new Date(System.currentTimeMillis() + 1000)) // 1초 지나면 유효시간 없음...
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 1초*60*60*24 1일 유효함
                .signWith(SignatureAlgorithm.HS256,
                                Base64.getEncoder().encodeToString(secretkey.getBytes()))
                .compact();
        return jwt;
    }

    // JWT 유효한지 검사 .... 우리가 설정한 비밀번호까지...
    public String validJWT(String jwt,String secrekey){
        try {
            SecretKey secretKey
                    = new SecretKeySpec(secrekey.getBytes(),
                    Jwts.SIG.HS256.key().build().getAlgorithm());
            Jws<Claims> cliams = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(jwt);
            // 만약에 유효시간이 지났으면... JWT 사용 못하게 하기 위한 구문...
            cliams.getPayload().getExpiration().before(new Date());
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "fail";
        }
        return "success";
    }
}
