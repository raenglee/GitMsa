package com.example.org.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {
    private final JWTManager jwtManager;

    public JWTFilter(JWTManager jwtManager){
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(auth);

        //JWT 토근이 유효한지 확인 해보는 함수
//        jwtManager.validJWT(auth);
        //게시판 유저 정보

        // 여기서 무조건 지나가는
        filterChain.doFilter(request,response);
    }


}
