package com.fh.shop.backend.common;

import javax.servlet.http.HttpServletRequest;

public class WebContext {
   private static ThreadLocal<HttpServletRequest> requestContext = new ThreadLocal<HttpServletRequest>();

   public static void setRequest(HttpServletRequest request){

      requestContext.set(request);
   }
   //取出信息
   public static  HttpServletRequest getRequest(){

      return requestContext.get();
   }
   //删除信息
   public static void  remove(){

      requestContext.remove();
   }
}
