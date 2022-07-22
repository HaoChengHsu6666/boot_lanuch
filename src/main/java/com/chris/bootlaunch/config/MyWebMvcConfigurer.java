package com.chris.bootlaunch.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {

    @Resource
    CustomHandlerInterceptor customHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        //註冊攔截器，攔截規則
        //多個攔截器時，以此添加，執行順序按添加順序
        registry.addInterceptor(customHandlerInterceptor).addPathPatterns("/*");
    }
}
