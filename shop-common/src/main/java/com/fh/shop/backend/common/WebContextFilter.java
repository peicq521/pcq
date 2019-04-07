package com.fh.shop.backend.common;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class WebContextFilter implements Filter {


    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
       WebContext.setRequest((HttpServletRequest) req);
       try {
           filterChain.doFilter(req,resp);
       }finally {
           WebContext.remove();
       }

    }

    public void destroy() {

    }
}
