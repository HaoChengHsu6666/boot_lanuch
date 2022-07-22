package com.chris.bootlaunch.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    //Swagger頁面上分別展示不同路徑的API

    @Bean
    public GroupedOpenApi restApi(){
        return GroupedOpenApi.builder()
                .group("rest-api")
                .pathsToMatch("/*")
                .build();
    }

    @Bean
    public GroupedOpenApi helloApi(){
        return GroupedOpenApi.builder()
                .group("hello")
                .pathsToMatch("/hello/**")
                .build();
    }
}
