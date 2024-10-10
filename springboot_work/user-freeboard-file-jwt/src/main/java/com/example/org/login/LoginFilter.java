package com.example.org.login;

import com.example.org.login.jwt.JWTManager;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

//spring security library
//@RequiredArgsConstructor 생성자 this... 어쩌고 대신 쓰는것임
public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JWTManager jwtManager;

    public LoginFilter(AuthenticationManager authenticationManager,
                       JWTManager jwtManager) {
        //post -> get방식으로
        this.setFilterProcessesUrl("/login");
//        this.setUsernameParameter("email");
        this.authenticationManager = authenticationManager;
        this.jwtManager = jwtManager;
    }

    //Alt+Enter로 추가, 로그인 시도 할 때 호출되는 메서드
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email, password);

        return authenticationManager.authenticate(token);
    }

    // Ctrl+O 로 추가, 로그인 성공 했을 때 login success -> JWT 토근 발행
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDetails userDetails = (UserDetails) authResult.getPrincipal();

//        String role = userDetails.getAuthorities().stream()
//                .map( grantedAuthority -> grantedAuthority.toString() ).toString();

        String role = "";
        for (var auth : userDetails.getAuthorities()) {
            role = auth.getAuthority();
        }

        String jwt = jwtManager.createJWT(userDetails.getUsername(), role);
        response.getWriter().write(jwt);
//        response.addHeader("Authorization", "Bearer " + jwt); 붙여도되고 안붙여도 되고
    }

    // 로그인 실패 했을 때 login fail -> username, password를 확인하세요
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        System.out.println("실패");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
                .write("check email and password");
    }
}
