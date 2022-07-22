package com.chris.bootlaunch.config.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;

@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {

    @Override
    public void onApplicationEvent(MyEvent event) {
      log.info(String.format("%s監聽到事件源: %s.", MyListener1.class.getName(), event.getSource()));
    }
}
