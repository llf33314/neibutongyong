package com.gt.inside.sso.core.controller;

import com.gt.inside.api.dto.UserDTO;
import com.gt.inside.api.util.CommonUtil;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by psr on 2017/10/23 0023.
 */
@Api(value = "/m/route/", description = "登录服务")
@Controller
@RequestMapping(value = "/m/route/")
public class RouteController {

    private static Logger logger = Logger.getLogger(RouteController.class);

    @Value("${sso.redirect.url}")
    private String defaultRedirectUrl;

    @RequestMapping("login")
    public String login(String redirectUrl, HttpServletRequest request){
        logger.debug("login");
        if (CommonUtil.isEmpty(redirectUrl) || "".equals(redirectUrl)){
            redirectUrl = defaultRedirectUrl;
        }
        request.getSession().setAttribute("redirectUrl", redirectUrl);
        return "redirect:/m/route/tologin";
    }

    @RequestMapping("tologin")
    public ModelAndView toLogin(HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        logger.debug("to login");
        String redirectUrl = (String) request.getSession().getAttribute("redirectUrl");
        if (CommonUtil.isEmpty(redirectUrl)){
            login(null,request);
        }
        mav.addObject("redirectUrl", redirectUrl);
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping("test")
    public void test(){
        String url = "http://192.168.3.98:7078/api/token/getUser";
        String token = "GTINSIDESSO9";
        String signKey = "sso";
        UserDTO userDTO = CommonUtil.getUser(url, token, signKey);
        System.out.println(userDTO.toString());
        System.out.println();
    }

}
