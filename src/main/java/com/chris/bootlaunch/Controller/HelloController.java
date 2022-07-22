package com.chris.bootlaunch.Controller;

import com.chris.bootlaunch.config.event.MyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @Resource
    private ApplicationContext applicationContext;

    @RequestMapping("/hello")
    public String hello(HttpServletRequest request,
                        HttpSession session) {

        applicationContext.publishEvent(new MyEvent("事件測試"));

        return "Hello Spring boot----1111";

//        //操作attribute
//        request.setAttribute("a","a");
//        request.setAttribute("a","b");
//        request.getAttribute("a");
//        request.removeAttribute("a");
//
//        //操作session
//        session.setAttribute("a","a");
//        session.getAttribute("a");
//        session.invalidate();


    }


}
