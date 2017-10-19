package com.gt.inside.sso.common.config;

import com.gt.inside.sso.common.filter.ApiFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;

/**
 * 过滤器配置
 * Created by Administrator on 2017/7/31 0031.
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean apiFilterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        registrationBean.setFilter(delegatingFilterProxy);
        registrationBean.setFilter(apiFilter());
        registrationBean.addUrlPatterns("/api/*"); //这里一定要加通配符  否则只会拦截 hostname/  这样的地址
        return registrationBean;
    }

    @Bean
    public Filter apiFilter(){
        return new ApiFilter();
    }

}
