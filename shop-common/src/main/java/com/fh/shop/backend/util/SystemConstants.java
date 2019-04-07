/** 
 * <pre>项目名称:shop-admin 
 * 文件名称:SystemConstants.java 
 * 包名:com.fh.shop.util 
 * 创建日期:2018年3月27日下午3:01:13 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.util;

/**
 * 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：SystemConstants    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午8:10:42    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午8:10:42    
 * 修改备注：       
 * @version </pre>
 */
public final class SystemConstants {

	public static final String PRODUCT_PICTURE_PATH = "/image/";

	public static final String PRODUCT_IMAGE_PATH = "/images/";
	
	public static final String LOGIN_USER = "loginUser";
	
	public static final int LOG_SUCCESS = 1;
	
	public static final int LOG_ERROR = 0;

	public static final  String IMAGE_CODE="/imageCode";

	public static final String USER_STATUS="ERROR";

	public static final int LOGIN_COUNT=1;

	public static final int LOGIN_ERROR_STATUS=2;

	public static  final String WHITE_LOGIN="toAdd.jhtml,addUser.jhtml,checkCunt.jhtml,api/product/findProductList.jhtml";

	public static final String USER_LOGIN_JSP="/login.jsp";
   //前台传过来的参数
	public static final String USERINFO="userInfo";

	public static final String  ORDER_COLUMN="order[0][column]";

	public static final String  ORDER_DIR="order[0][dir]";
	// 存储通名称			替换成自己的
	public static final String BUCKENT_NAME = "wangyazhou-1258865969";
	//secretId 			替换成自己的
	public static final String SECRET_ID = "AKIDhKEA87YdLg7aJWfW8f6Qfx7B7sTTuZSQ";
	// secretKey		????   ?替换成自己的
	public static final String SECRET_KEY = "EVpNzxzw08KaBpkr2HaxMoP8PnEiH940";

	public static String REGION="ap-beijing";

	public static String COS_UPLOADURL="http://wangyazhou-1258865969.cos.ap-beijing.myqcloud.com/";

	public enum ProductStatusEnum{
		PASSWORD_ERROR,USERNAME_ERROR
    }

}
