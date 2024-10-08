package com.pmh.org.conf;

import com.pmh.org.jwt.JWTFilter;
import com.pmh.org.login.LoginFilter;
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

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf( csrf -> csrf.disable() );
        http.formLogin( form -> form.disable());
        http.httpBasic( basic -> basic.disable());

        http.authorizeRequests( auth -> auth
                // 일반 사용자도 접근 가능하다
                .requestMatchers( "/","/login", "/join",  "/freeboard/**","/user/**" ,"/file/**").permitAll()
                // swagger 문서...
                .requestMatchers( "/swagger-ui/**", "/v3/api-docs/**" ).permitAll()
                .requestMatchers( "/kakao/**").permitAll()
                .requestMatchers("/test/**").permitAll()
                // AMDIN 으로 role 을 가지고 있을때 접근 가능 하다.
                .requestMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated() );

        http.addFilterBefore(new JWTFilter(),LoginFilter.class);
        http.addFilterAt( new LoginFilter(
                                    authenticationManager(authenticationConfiguration)
                                ),
                                UsernamePasswordAuthenticationFilter.class);

        http.sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ));

        return http.build();
    }

}
