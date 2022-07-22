package com.chris.bootlaunch;

import com.chris.bootlaunch.model.LombokPOJO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BootLaunchApplication {

    public static void main(String[] args) {



//        LombokPOJO lombokPOJO = LombokPOJO.builder()
//                .name("haha")
//                .age(23)
//                .build();

        SpringApplication.run(BootLaunchApplication.class, args

        );
    }

}
