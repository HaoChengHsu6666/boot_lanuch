package com.chris.bootlaunch.config.event;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;

@Configuration
public class BeanRunner {

    // ApplicationRunner執行優先大於CommandLineRunner

    @Bean //為實例化CommandLineRunner
    @Order(1) //只可保證同類(CommandLineRunner)的執行順序
    public CommandLineRunner runner1(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                System.out.println("BeanCommandLineRunner run1()" + Arrays.toString(args));
            }
        };
    }

    @Bean
    @Order(2)
    public CommandLineRunner runner2(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                System.out.println("BeanCommandLineRunner run2()" + Arrays.toString(args));
            }
        };
    }

    @Bean
    @Order(3)
    public ApplicationRunner runner3(){
        return new ApplicationRunner() {
            @Override
            public void run(ApplicationArguments args) {
                System.out.println("BeanCommandLineRunner run3()" + Arrays.toString(args.getSourceArgs()));
            }
        };
    }
}
