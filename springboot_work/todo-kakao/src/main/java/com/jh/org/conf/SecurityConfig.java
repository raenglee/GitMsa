package com.jh.org.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // csrf 위변조 기능 사용 안함 (jwt토큰방식에선 쓸 필요가 없음)
        httpSecurity.csrf(csrf -> csrf.disable());
        // form 로그인 방식 사용 안함
        httpSecurity.formLogin(form -> form.disable());
        // httpBasic 로그인 방식 사용 안함
        httpSecurity.httpBasic(http -> http.disable());

        // 모든 페이지 요청 허용
        httpSecurity.authorizeHttpRequests(
                auth -> auth.requestMatchers("/**").permitAll()
        );

        // 세션 유지 기능 사용 안함
        httpSecurity.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return httpSecurity.build();


    }
}
