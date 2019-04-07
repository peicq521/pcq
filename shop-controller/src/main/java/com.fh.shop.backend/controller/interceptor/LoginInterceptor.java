/**
 * <pre>项目名称:shop_admin_v2
 * 文件名称:MyInterceptor.java
 * 包名:com.fh.shop.backend.intercepter
 * 创建日期:2019年1月7日下午8:05:06
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre>
 */
package com.fh.shop.backend.controller.interceptor;

import com.fh.shop.backend.po.user.User;
import com.fh.shop.backend.util.SystemConstants;
import com.fh.util.CookieUtil;
import com.fh.util.RedisUtil;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre>项目名称：shop_admin_v2    
 * 类名称：MyInterceptor    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午8:05:06    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午8:05:06    
 * 修改备注：       
 * @version </pre>    
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String path = request.getServletPath();
        String whiteLogin = SystemConstants.WHITE_LOGIN;
        String[] split = whiteLogin.split(",");
        for (String s : split) {
            if (path.endsWith(s)) {
                return true;
            }
        }
	/*	String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();*/
       // Object userInfo = request.getSession().getAttribute(SystemConstants.LOGIN_USER);\
        String loginId = CookieUtil.readCookie("loginId", request);
        if(StringUtils.isEmpty(loginId)){
            response.sendRedirect(request.getContextPath() + SystemConstants.USER_LOGIN_JSP);
            return false;
        }
        String s = RedisUtil.get("user:" + loginId);
        Gson gson = new Gson();
        User userInfo = gson.fromJson(s, User.class);
        RedisUtil.setnx("user:"+loginId,30*60);

        if (null != userInfo) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + SystemConstants.USER_LOGIN_JSP);
            return false;
        }
    }
}
