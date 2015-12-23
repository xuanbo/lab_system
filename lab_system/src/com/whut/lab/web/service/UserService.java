package com.whut.lab.web.service;

import com.whut.lab.web.entity.User;

/**
 * userService接口
 * @author xuan
 *
 */
public interface UserService extends BaseService <User, Integer>{
	
	/**
	 * 是否能根据用户名找到密码
	 * @param name
	 * @param password
	 * @return
	 */
	public boolean isFindPasswordByName(String name, String password);
}
