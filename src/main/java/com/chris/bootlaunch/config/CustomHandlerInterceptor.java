package com.chris.bootlaunch.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class CustomHandlerInterceptor implements HandlerInterceptor, org.springframework.web.servlet.HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        log.info("preHandle: 請求前調用");
        return true;
    }

    @Override
    public void  postHandler(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
        log.info("postHandle: 請求後調用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception{
        log.info("afterCompletion: 請求調用完後回調方法, 即在視圖渲染完成後回調");
    }


}
