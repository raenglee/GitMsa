package com.pmh.org.filter;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("지나갈때 호출되는 메서드");
        System.out.println(servletRequest.getParameter("test"));
        filterChain.doFilter(servletRequest,servletResponse);
    }
    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
