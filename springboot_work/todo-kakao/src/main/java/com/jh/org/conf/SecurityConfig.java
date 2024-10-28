package com.jh.org.conf;

import com.jh.org.filter.JWTUtils;
import com.jh.org.filter.SecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // csrf 위변조 기능 안함..
        httpSecurity.csrf(csrf -> csrf.disable());
        // form 로긴 방식 사용 안함..
        httpSecurity.formLogin(form -> form.disable());
        // httpBasic 로그인 방식 사용 안함.
        httpSecurity.httpBasic(http -> http.disable());

        // 스프링 스큐리티... -> PasswordEncoder...
        httpSecurity.authorizeHttpRequests( auth -> auth.requestMatchers("/**").permitAll());

        httpSecurity.addFilterAt(
                new SecurityFilter(new JWTUtils()),
                UsernamePasswordAuthenticationFilter.class);

        // 세션 유지 기능 사용 안함..
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();
    }

}