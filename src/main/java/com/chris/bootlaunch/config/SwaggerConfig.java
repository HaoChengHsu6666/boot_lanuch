//package com.chris.bootlaunch.config;
//
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class SwaggerConfig {
//

        // Swagger 2.0 配置文件

//    //Swagger文檔產生網址： http://localhost:8888/swagger-ui.html
//
//    //創建文檔
//    private ApiInfo apiInfo(){
//        return new ApiInfoBuilder()
//                .title("springboot利用swagger建構api文檔")
//                .description("簡單的restful風格")
//                //請求的協議
//                .termsOfServiceUrl("http://www.chrishsu.com")
//                .version("1.0")
//                .build();
//    }
//
//
//    public Docket createRestApi(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                //掃描basePackage下面的"/rest/"路徑下的內容作為接口文檔構建的目標
//                .apis(RequestHandlerSelectors.basePackage("com.chris.bootlaunch"))
//                //針對那些路徑請求形成接口文檔
//                .paths(PathSelectors.regex("/.*"))
//                .build();
//    }
//
//}
