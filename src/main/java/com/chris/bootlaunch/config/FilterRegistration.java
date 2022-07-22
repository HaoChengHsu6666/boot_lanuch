package com.chris.bootlaunch.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistration {

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        //Filter可以new，也可以使用依賴注入Bean
        registration.setFilter(new CustomFilter());
        //過濾器名稱
        registration.setName("customFilter");
        //攔截路徑
        registration.addUrlPatterns("/*");
        //設置順序，數字越小，執行順序越前面
        registration.setOrder(10);
        return registration;
    }


}
