/** 
 * <pre>项目名称:shop_admin_v4 
 * 文件名称:AopInfo.java 
 * 包名:com.fh.shop.backend.aopServlet 
 * 创建日期:2019年1月21日上午11:02:03 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.aopServlet;

import com.fh.shop.backend.biz.log.ILogService;
import com.fh.shop.backend.common.WebContext;
import com.fh.shop.backend.po.log.LogInfo;
import com.fh.shop.backend.po.user.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Date;

/** 
 * <pre>项目名称：shop_admin_v4    
 * 类名称：AopInfo    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月21日 上午11:02:03    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月21日 上午11:02:03    
 * 修改备注：       
 * @version </pre>    
 */
public class AopInfo {

	@Resource(name="logService")
	private ILogService logService;
    
	private static final Logger LOG =  LoggerFactory.getLogger(AopInfo.class);
	
	public Object say(ProceedingJoinPoint pjp){
		//类的全称
		String packageName = pjp.getTarget().getClass().getCanonicalName();
		//方法名
		String methodName = pjp.getSignature().getName();
		//返回值\由核心业务逻辑决定返回值
		Object result = null;
		//用户信息
		User userInfo = null;
		//是否成功
		Integer  status = 0;
		//当前的毫秒值
		Long statTime = null;
		//结束时间
		Long endTime = null;

		try {
			//当前的毫秒值
			statTime = System.currentTimeMillis();
			//执行真正的方法
			result = pjp.proceed();
			//结束时间
			endTime = System.currentTimeMillis();

			status = 1;

			if (userInfo!=null) {

				userInfo = (User) WebContext.getRequest().getSession().getAttribute("user");

				//System.out.print(userInfo.getUserName()+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

				LOG.info("{}成功执行{}中的{}方法", userInfo.getUserName(), packageName, methodName);


			}

		} catch (Throwable e) {

			e.printStackTrace();

			LOG.info("执行{}中的{}方法时出现系统繁忙"+e.getMessage(),packageName,methodName);

			return result;
		}

		if(userInfo != null) {

			LogInfo log = new LogInfo();

			log.setUserName(userInfo.getUserName());

			log.setInfo(packageName + "中的" + methodName);

			log.setStatus(status);

			Date now = new Date();

			log.setCreateTime(now);

			log.setUseTime(endTime - statTime);

			System.out.print(log + "++++++++++++++++++++++++++++++++++++++++++++++++");

			logService.addLog(log);
		}
		return result;
	}

}
