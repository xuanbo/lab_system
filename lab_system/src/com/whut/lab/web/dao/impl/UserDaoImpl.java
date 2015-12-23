package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.UserDao;
import com.whut.lab.web.entity.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl <User, Integer> implements UserDao{

}
