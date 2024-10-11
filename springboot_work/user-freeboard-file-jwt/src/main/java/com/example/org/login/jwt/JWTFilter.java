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

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);

        // 인증 토큰인 JWT 가 null 이거나 Bearer 로 시작하는 토큰이 아니면 로그인 처리 안함
        if (auth == null || !auth.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        // JWT 토큰이 넘어오면
        else {
            try {
                // JWT 토큰이 유효한지 확인 해보는 함수 -> jwtManager.validJWT(auth);
                // Bearer asdlckfjnqwlekjcnaslkdcjfnl
                String token = auth.split(" ")[1];
                // 토큰이 유효한지 검사해서 해당되는 이메일과 역할 정보를 가지고 옴
                Jws<Claims> claims = jwtManager.getClaims(token);
                String email = claims.getPayload().get("email").toString();
                String role = claims.getPayload().get("role").toString();
                LoginUserDetails loginUserDetails = new LoginUserDetails(email, null, role);
                Authentication authentication = new UsernamePasswordAuthenticationToken(
                        loginUserDetails, null,
                        loginUserDetails.getAuthorities()
                );
                //로그인 했는것을 가져감
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                throw new AuthException(e.getMessage());
            }
        }

        // 여기서 무조건 지나가는
        filterChain.doFilter(request, response);
        // doFilter가 있는 FreeboardController로 이동
    }
}

        // 회원가입이나 로그인으로 들어와을 땐 로그인 설정을 하지 않고 지나가도록
//        if (request.getRequestURI().contains("join")
//                || request.getRequestURI().contains("login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }
