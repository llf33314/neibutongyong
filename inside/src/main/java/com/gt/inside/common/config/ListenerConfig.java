package com.gt.inside.common.config;

import com.gt.inside.common.listener.StartListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContextListener;

/**
 * 过滤器配置
 * Created by Administrator on 2017/7/31 0031.
 */
@Configuration
public class ListenerConfig {

    @Bean
    public ServletListenerRegistrationBean startListenerRegistrationBean(){
        ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();
        servletListenerRegistrationBean.setListener(startListener());
        return servletListenerRegistrationBean;
    }

    @Bean
    public ServletContextListener startListener(){
        return new StartListener();
    }

}
