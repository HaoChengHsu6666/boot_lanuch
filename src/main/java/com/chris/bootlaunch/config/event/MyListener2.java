package com.chris.bootlaunch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MyListener2 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event){
        log.info(String.format("%s監聽到事件源: %s.", MyListener2.class.getName(), event.getSource()));
    }


}
