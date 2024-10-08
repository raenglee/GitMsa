package com.example.org.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

@Configuration  //IOC컨테이너만들어서 환경설정하는것
public class JpaAudtiConfig {

    @Bean // 객체임을 알림
    public AuditorAware<String> auditorAware(){
        AuditorAware<String> auditorAware =
                () -> Optional.of("길동");

        return auditorAware;
    }
}
