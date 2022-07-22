package com.chris.bootlaunch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Slf4j
public class AppStartupRunner implements ApplicationRunner {

    //以@Component註解的方式優先級大於@Bean註解的方式

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("CommandLineStartupRunner參數名稱: {}", args.getOptionNames());
        log.info("CommandLineStartupRunner參數值: {}", args.getOptionValues("age"));
        log.info("CommandLineStartupRunner參數: {}", Arrays.toString(args.getSourceArgs()));
    }
}
