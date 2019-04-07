/** 
 * <pre>项目名称:shop_admin_v2 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.fh.shop.backend.biz.user 
 * 创建日期:2019年1月7日下午3:55:02 
 * Copyright (c) 2019, xxxxxx@163.com All Rights Reserved.</pre> 
 */  
package com.fh.shop.backend.biz.user;

import com.fh.shop.backend.mapper.user.IUserMapper;
import com.fh.shop.backend.po.user.User;
import com.fh.shop.backend.serverResponse.ResponseEnum;
import com.fh.shop.backend.serverResponse.ServerResponse;
import com.fh.util.DateUtil;
import com.fh.util.MD5Util;
import com.fh.util.TXCos;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** 
 * <pre>项目名称：shop_admin_v2    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：王亚州 2592683566@qq.com    
 * 创建时间：2019年1月7日 下午3:55:02    
 * 修改人：王亚州 2592683566@qq.com     
 * 修改时间：2019年1月7日 下午3:55:02    
 * 修改备注：       
 * @version </pre>    
 */
@Service("userService")
public class UserServiceImpl implements IUserService{
    @Autowired
	private IUserMapper userMapper;

	/* (non-Javadoc)    
	 * @see com.fh.shop.backend.biz.user.IUserService#login(com.fh.shop.backend.po.user.User)    
	 */

	public User checkCunt(User user) {
		User userInfo = userMapper.checkCunt(user);
		return userInfo;
	}

    public ServerResponse addUser(User user) {
		if(StringUtils.isNotEmpty(user.getUserName())){
			User userInfo = userMapper.checkCunt(user);
			if(userInfo==null){
				String s = UUID.randomUUID().toString();
				user.setSalt(s);
				String newPassWord = MD5Util.getStringMD5(MD5Util.getStringMD5(user.getPassWord()) + s);
				user.setPassWord(newPassWord);
				userMapper.addUser(user);
			}
			return ServerResponse.error(ResponseEnum.USER_EMPTY);
		}

     return ServerResponse.error();
    }

	public void updateUser(User userInfo) {
		userMapper.updateUser(userInfo);
		String headerPath = userInfo.getHeaderPath();
		String oldHeaderPath = userInfo.getOldHeaderPath();
		if (StringUtils.isNotEmpty(headerPath)){
			TXCos.delete(oldHeaderPath);
		}else {
			userInfo.setHeaderPath(oldHeaderPath);
		}
		userMapper.updateUser(userInfo);
	}

    @Override
    public void deleteUser(Integer id) {
        userMapper.deleteUser(id);
    }

	@Override
	public  User findUserById(Integer id) {
		User userInfo =	userMapper.findUserById(id);
		userInfo.setBirthdayStr(DateUtil.date2Str(userInfo.getBirthday(),DateUtil.L_M_D));
		return userInfo;
	}

    @Override
    public Long queryCount(User user) {

		Long checkCunt = userMapper.queryCount(user);
		return checkCunt;
    }

	@Override
	public List<User> findUser(User user) {
		List<Integer> list = new ArrayList<>();
		String deptIds = user.getDeptIds();
		if(StringUtils.isNotEmpty(deptIds)){
			String[] idsArr = deptIds.substring(1).split(",");
			for (String s : idsArr) {
				list.add(Integer.parseInt(s));
			}

			user.setDeptIdsList(list);
		}
		List<User> userList = userMapper.findUser(user);
		return userList;
	}

	@Override
	public void addUserInfo(User user) {
		user.setHeaderPath(user.getHeaderPath());
		userMapper.addUserInfo(user);
	}

	@Override
	public void deleteUserInfo(List<Integer> ids) {
		userMapper.deleteUserInfo(ids);
	}

	@Override
	public void updateDept(List<Integer> ids, Integer deptIds) {
		userMapper.updateDept(ids,deptIds);
	}

	@Override
	public void updateUserDept(User user) {
		user.setHeaderPath(user.getHeaderPath().substring(1));
		userMapper.updateUserDept(user);
	}

}
