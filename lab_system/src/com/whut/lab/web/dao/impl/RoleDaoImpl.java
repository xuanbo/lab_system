package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.RoleDao;
import com.whut.lab.web.entity.Role;

@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role, Integer> implements RoleDao{

}
