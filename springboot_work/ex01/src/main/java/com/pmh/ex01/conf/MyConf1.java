package com.pmh.ex01.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 스프링 객체 담는 통임을 명시하는 것
@Configuration
//어떤 디렉토리를 읽어서(어떤 디렉토리를 읽은건지는 괄호안에) 객체를 주입 해달라는 것
@ComponentScan(basePackages ="com.pmh.ex01.member" )
public class MyConf1 {
}
