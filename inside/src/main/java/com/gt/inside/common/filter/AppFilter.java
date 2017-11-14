package com.gt.inside.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目过滤器
 * Created by psr on 2017/9/13 0013.
 */
public class AppFilter implements Filter {

    private static Logger logger = Logger.getLogger(AppFilter.class);

    @Value("${inside.sso.sign.key}")
    private String signKey;

    @Value("${inside.sso.url}")
    private String ssoUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Accept, Origin, XRequestedWith, Content-Type, LastModified, token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("application/json; charset=utf-8");

        logger.debug("app filter");

        String token = (String) httpServletRequest.getHeader("token");
        if(token == null){
            servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByEnums(ResponseEnums.LOGIN)));
            return;
        }else{
            //不为空
            UserDTO userDTO = CommonUtil.getUser(ssoUrl + "api/token/getUser", token, signKey);
            if (CommonUtil.isEmpty(userDTO)){
                servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByEnums(ResponseEnums.LOGIN)));
                return;
            }else{
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
