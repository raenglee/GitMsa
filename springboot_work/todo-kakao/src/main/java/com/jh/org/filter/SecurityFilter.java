package com.jh.org.filter;

import com.jh.org.error.UserException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//@Component
@Slf4j
public class SecurityFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;

    public SecurityFilter(JWTUtils jwtUtils) {
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String authorization =request.getHeader("Authorization");
            log.info("Security Filter"+authorization);

            String jwt = authorization.split("Bearer ")[1];
            String email = jwtUtils.getEmailFromJwt(jwt);
            Authentication authentication =
                    new UsernamePasswordAuthenticationToken(
                            User.builder()
                                    .username(email)
                                    .password("temp")
                                    .roles("ADMIN")
                                    .build()
                            , null
                    );

            SecurityContextHolder.getContext().setAuthentication(authentication);
        }catch (Exception e) {

        }
        filterChain.doFilter(request, response);
    }
}
