package com.gt.inside.common.listener;

import com.gt.inside.api.util.SocketUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 启动监听器
 * Created by psr on 2017/11/22 0022.
 */
public class StartListener implements ServletContextListener{

    @Value("${inside.socket.url}")
    private String socketUrl;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        SocketUtil.connect(socketUrl);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
