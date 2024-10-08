package com.pmh.org.login;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    public LoginFilter(AuthenticationManager authenticationManager) {
        this.setFilterProcessesUrl("/login");
        this.authenticationManager = authenticationManager;
    }
    // 로그인 시도
    @Override
    public Authentication attemptAuthentication(
                HttpServletRequest request,
                HttpServletResponse response) throws AuthenticationException {
//        System.out.println("로그인시도");

//        String username = this.obtainPassword(request);
//        System.out.println("username = " + username);

//        try{
//            JoinDto joinDto = new ObjectMapper().read(request.getInputStream(),JoinDto.class);
//            System.out.println("joinDto = " + joinDto);
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(email,password);
        return authenticationManager.authenticate(token);
    }

    // 로그인 성공... jwt 토큰발행
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        System.out.println("성공");
        response.getWriter().write("success");
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request,
                                              HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter()
                .write("check email and password");
    }
}
