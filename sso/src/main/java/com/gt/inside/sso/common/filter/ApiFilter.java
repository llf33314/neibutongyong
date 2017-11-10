package com.gt.inside.sso.common.filter;

import com.alibaba.fastjson.JSONObject;
import com.gt.inside.api.dto.ResponseDTO;
import com.gt.inside.api.enums.ResponseEnums;
import com.gt.inside.api.util.CommonUtil;
import com.gt.inside.api.util.SignFilterUtils;
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
public class ApiFilter implements Filter {

    private static Logger logger = Logger.getLogger(ApiFilter.class);

    @Value("${sso.sign.key}")
    private String signKey;

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

        logger.debug("api filter");
        /*Integer code = SignFilterUtils.postByHttp(servletRequest, signKey);
        logger.debug(code);
        if (ResponseEnums.SIGN_TIME_OUT.getCode() == code){
            // 超过指定时间
            servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByEnums(ResponseEnums.SIGN_TIME_OUT)));
            return;
        }else if (ResponseEnums.SIGN_ERROR.getCode() == code){
            // 签名验证错误
            servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByEnums(ResponseEnums.SIGN_ERROR)));
            return;
        }
        String token = ((HttpServletRequest)servletRequest).getHeader("token");
        if (CommonUtil.isEmpty(token)){
            // token为空
            servletResponse.getWriter().write(JSONObject.toJSONString(ResponseDTO.createByEnums(ResponseEnums.TOKEN_NULL)));
            return;
        }
        logger.debug("api token --> " + token);*/

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
