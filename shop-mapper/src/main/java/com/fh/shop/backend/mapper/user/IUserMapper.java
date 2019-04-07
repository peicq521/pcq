/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:IUserMapper.java 
 * 包名:com.fh.shop.backend.mapper.user 
 * 创建日期:2019年1月7日下午3:55:48 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.mapper.user;

import com.fh.shop.backend.po.user.User;

import java.util.List;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：IUserMapper    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午3:55:48    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午3:55:48    
 * 修改备注：       
 * @version </pre>    
 */
public interface IUserMapper {

	/** <pre>user(这里用一句话描述这个方法的作用)   
	 * 创建人：王亚州 2592683566@qq.com    
	 * 创建时间：2019年1月7日 下午4:08:56    
	 * 修改人：王亚州 2592683566@qq.com     
	 * 修改时间：2019年1月7日 下午4:08:56    
	 * 修改备注： 
	 * @param user
	 * @return</pre>    
	 */
	User checkCunt(User user);

    void addUser(User user);

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
