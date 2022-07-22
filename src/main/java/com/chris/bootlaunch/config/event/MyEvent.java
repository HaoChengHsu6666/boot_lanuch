package com.chris.bootlaunch.config.event;

import org.springframework.context.ApplicationEvent;

public class MyEvent extends ApplicationEvent {
    public MyEvent(Object source){
        super(source);
    }

    //Spring 4種監聽器實現方式
    /*

    1.寫代碼向ApplicationContext中添加監聽器
    2.使用Component註解將監聽器裝載入Spring容器
    3.在application.properties中配置監聽器
    4.通過@EventListener註解實現事件監聽

     */

}
