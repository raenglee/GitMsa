package com.green.userservice.conf;

import io.micrometer.core.aop.TimedAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 마이크로미터 환경설정 파일
@Configuration
public class TimedConfig {

    @Bean
    public TimedAspect timedAspect(){
        return new TimedAspect();
    }

}
