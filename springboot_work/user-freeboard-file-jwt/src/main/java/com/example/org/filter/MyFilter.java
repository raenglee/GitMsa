package com.example.org.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//이 Filter들은 공부를 위해 만든것이고 작동하는데에는 굳이 필요 없음
//@Component <- 얘만 주석처리해도 밑에 내용들 실행 안됨
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("필터 생설될 때 호출되는 메서드");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("필터 지나갈 때 호출되는 메서드");
        System.out.println(servletRequest.getParameter("com/example/org/test"));
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("필터 파괴될 때 호출되는 메서드");
        Filter.super.destroy();
    }
}
