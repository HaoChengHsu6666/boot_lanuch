package com.chris.bootlaunch.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(String name){

        String path = "a.txt";

        return "Hello Spring boot----1111" + name;
    }


}
