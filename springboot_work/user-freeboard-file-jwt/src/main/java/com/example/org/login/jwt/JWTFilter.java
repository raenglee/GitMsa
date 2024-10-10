package com.example.org.login.jwt;

import com.example.org.login.LoginUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

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

        System.out.println("여기를 무조건 지나간다.");

        String auth = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(auth);

        // 인증 토큰인 JWT 가 null 이거나 Bearer 로 시작하는 토큰이 아니면...
        if (auth == null || !auth.startsWith("Bearer ")) {
            // 그냥 지나가라...
            filterChain.doFilter(request, response);
            return;
        }
        // 회원가입이나 로그인으로 들어와을 땐 로그인 설정을 하지 않고 지나가도록
//        if (request.getRequestURI().contains("join")
//                || request.getRequestURI().contains("login")) {
//            filterChain.doFilter(request, response);
//            return;
//        }

        // JWT 토큰이 유효한지 확인 해보는 함수 -> jwtManager.validJWT(auth);
        // Bearer asdlckfjnqwlekjcnaslkdcjfnl
        try {
            String token = auth.split(" ")[1];
            Jws<Claims> claims = jwtManager.getClaims(token);
            String email = claims.getPayload().get("email").toString();
            String role = claims.getPayload().get("role").toString();
            LoginUserDetails loginUserDetails = new LoginUserDetails(email, null, role);

            System.out.println(loginUserDetails);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    loginUserDetails, null, loginUserDetails.getAuthorities()
            );
            //로그인 했는것을 가져감
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 여기서 무조건 지나가는
        filterChain.doFilter(request, response);
    }
}
