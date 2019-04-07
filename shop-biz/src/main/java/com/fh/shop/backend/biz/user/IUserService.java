/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:IUserService.java 
 * 包名:com.fh.shop.backend.biz.user 
 * 创建日期:2019年1月7日下午3:54:45 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.biz.user;

import com.fh.shop.backend.po.user.User;
import com.fh.shop.backend.serverResponse.ServerResponse;

import java.util.List;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：IUserService    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午3:54:45    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午3:54:45    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserService {

	/** <pre>login(这里用一句话描述这个方法的作用)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2019年1月7日 下午4:07:26    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2019年1月7日 下午4:07:26    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	User checkCunt(User user);

	ServerResponse addUser(User user);

	void updateUser(User userInfo);

    void deleteUser(Integer id);

	User findUserById(Integer id);

    Long queryCount(User user);

	List<User> findUser(User user);

	void addUserInfo(User user);

	void deleteUserInfo(List<Integer> ids);

    void updateDept(List<Integer> ids, Integer deptIds);

	void updateUserDept(User user);
}
