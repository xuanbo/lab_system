package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.whut.lab.web.entity.User;
import com.whut.lab.web.service.UserService;

/**
 * 
 * @author xuan
 *
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl <User, Integer> implements UserService {

	@Override
	public boolean isFindPasswordByName(String name, String password) {
	    List<User> users = super.getByName(name);
		if(users.size() == 0){
			return false;
		}else if(users.get(0).getPassword().equals(password)){
			return true;
		}else{
			return false;
		}
	}

}
