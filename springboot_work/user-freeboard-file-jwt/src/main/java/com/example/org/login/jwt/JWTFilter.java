package com.example.org.login.jwt;

import com.example.org.login.LoginUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.security.auth.message.AuthException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//무조건 아래 doFilter로 감
@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTManager jwtManager;

    public JWTFilter(JWTManager jwtManager) {
        this.jwtManager = jwtManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {


        // axois.get(data,{'headers':{ 'authroization': 'asdfasdf' })
        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        //  jwt 토큰이 넘어오지 않으면...로그인 처리 안함..
        if(auth == null || !auth.startsWith("Bearer ")) {
            // 헤더에 jwt 토큰 넘어오지 않으면 하고 싶은거 하러가라...
            filterChain.doFilter(request, response);
            return;
        }
        // jwt 토큰이 넘어 오면...
        else {
            try {
                // Bearer eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFhYUBuYXZlci5jb20iLCJyb2xlIjoiUk9MRV9BRE1JTiIsImlhdCI6MTcyODYxMjAzNCwiZXhwIjoxNzI4Njk4NDM0fQ.DImwEJGtTTQfm4I2cxiFHV3R3ZxnYiPCl-Vw2MFUkYg
                String token = auth.split(" ")[1];
                // token 이 유효한지 검사해서 해당되는 email, role 정보들을 가지고 옵니다.
                Jws<Claims> claims = jwtManager.getClaims(token);
                String email = claims.getPayload().get("email").toString();
                String role = claims.getPayload().get("role").toString();
                LoginUserDetails loginUserDetails = new LoginUserDetails(email,null, role);
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        loginUserDetails, null,
                        // ROLE_ADMIN
                        loginUserDetails.getAuthorities()
                );
                // 로그인설정
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                throw new AuthException(e.getMessage());
            }
        }

        // freeboard >>>
        // todo >>>
        // user >>>
        filterChain.doFilter(request,response);
    }
}

//        여기서 무조건 지나가는
//        filterChain.doFilter(request, response);
//        doFilter가 있는 FreeboardController로 이동
//    }
//}

        // 회원가입이나 로그인으로 들어와을 땐 로그인 설정을 하지 않고 지나가도록
//        if (request.getRequestURI().contains("join")
//                || request.getRequestURI().contains("login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
