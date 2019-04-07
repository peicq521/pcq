/** 
 * <pre>项目名称:shop_admin_v4 
 * 文件名称:ServerResponse.java 
 * 包名:com.fh.shop.backend.commom 
 * 创建日期:2019年1月12日上午10:36:14 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.serverResponse;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop_admin_v4    
 * 类名称：ServerResponse    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月12日 上午10:36:14    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月12日 上午10:36:14    
 * 修改备注：       
 * @version </pre>    
 */
public class ServerResponse implements Serializable{
       
	private static final long serialVersionUID = 3054243132708898953L;
	private int code;
	private String msg;
	private Object data;
	
    public static ServerResponse success(){
    	return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),null);
    }	
    
    public static ServerResponse error(){
    	return new ServerResponse(ResponseEnum.ERROR.getCode(),ResponseEnum.ERROR.getMsg(),null);
    }
    
    public static ServerResponse error(ResponseEnum responseEnum){
    	return new ServerResponse(responseEnum.getCode(),responseEnum.getMsg(),null);
    }
	public static  ServerResponse success(Object data){
		return new ServerResponse(ResponseEnum.SUCCESS.getCode(),ResponseEnum.SUCCESS.getMsg(),data);
	}
    
	/**    
	 * <pre>创建一个新的实例 ServerResponse.    
	 *    
	 * @param code
	 * @param msg
	 * @param data</pre>    
	 */
	private ServerResponse(int code, String msg, Object data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}
	/**    
	 * <pre>创建一个新的实例 ServerResponse.    
	 *    </pre>    
	 */
	private ServerResponse() {
	}
	public int getCode() {
		return code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public Object getData() {
		return data;
	}
	
	
	
}
