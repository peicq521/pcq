/** 
 * <pre>项目名称:shop_admin_v4 
 * 文件名称:ResponseEnum.java 
 * 包名:com.fh.shop.backend.serverResponse 
 * 创建日期:2019年1月12日上午11:27:46 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.serverResponse;

/** 
 * <pre>项目名称：shop_admin_v4    
 * 类名称：ResponseEnum    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月12日 上午11:27:46    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月12日 上午11:27:46    
 * 修改备注：       
 * @version </pre>    
 */
public enum ResponseEnum {
	   USERNAME_USERPWD_EMPTY(1000,"账号或密码或验证码不正确"),
	   USERNAME_EMPTY(1001,"账号不存在"),
	   USERPWD_EMPTY(1002,"密码错误"),
	  IMAGECODE_EMPTY(1003,"验证码错误"),
	 ERROR(-1,"系统错误,请联系管理员"),
	 USER_EMPTY(1,"账号已经被注册"),
	USER_LOCK(2,"账号被锁定"),
	SUCCESS(200,"登录成功");

	
      private  int code;
	  private String msg;
	  
	/**    
	 * <pre>创建一个新的实例 ResponseEnum.    
	 *    
	 * @param name
	 * @param ordinal</pre>    
	 */
	private ResponseEnum() {
	}
	/**    
	 * <pre>创建一个新的实例 ResponseEnum.    
	 *    
	 * @param code
	 * @param msg</pre>    
	 */
	private ResponseEnum(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
	  
}
