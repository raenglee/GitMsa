package com.example.org.conf;

import com.example.org.filter.JWTFilter;
import com.example.org.login.LoginFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationConfiguration authenticationConfiguration;

//    public SecurityConfig(AuthenticationConfiguration authenticationConfiguration) {
//        this.authenticationConfiguration = authenticationConfiguration;
//    }  이 세줄 == @RequiredArgsConstructor


    // spring session -> attemptAuthentication
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    //패스워드 데이터에 암호화 해넣는 객체 주입
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //csrf 사용안함
        http.csrf(csrf -> csrf.disable());
        //폼로그인 사용안함
        http.formLogin(form -> form.disable());
        // http 베이직 방법 사용 안함
        http.httpBasic(basic -> basic.disable());
        // 람다 csrf, form, basic은 변수명

        http.authorizeHttpRequests(auth -> auth
                // 일반 사용자들 접근 가능 (페이지 접근 허용)
                .requestMatchers("/login", "/join", "/", "/freeboard/**", "/user/**").permitAll()
                //swagger 문서와 접근 가능하게
                .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                .requestMatchers("/test/**").permitAll()
                // ADMIN으로 로그인해야(ADMIN Role을 가져야) 접근 가능
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated());

        http.addFilterBefore(new JWTFilter(), LoginFilter.class);
        http.addFilterAt(new LoginFilter(
                        authenticationManager(authenticationConfiguration)
                ),
                UsernamePasswordAuthenticationFilter.class);

        //기존 세션 방식을 사용하지 않겠다(세션 없도록 하겠다)
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
