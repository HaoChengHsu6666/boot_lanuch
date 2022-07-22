package com.chris.bootlaunch.config;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Slf4j
//註冊過濾器方式之一：加上@WebFilter註解，需在Application啟動類上加上註解@ServletComponentScan，缺點為無法確定過濾器的執行順序
//@WebFilter(filterName="costomFilter",urlPatterns={"/*"})
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("filter 初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        log.info("customFilter 請求處理之前----doFilter方法之前做過濾請求");
        servletRequest.setCharacterEncoding("UTF-8");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.setCharacterEncoding("UTF-8");
        log.info("customFilter 請求處理之後----doFilter方法之後做處理響應");
    }

    @Override
    public void destroy() {
        log.info("filter 銷毀");
    }
}
