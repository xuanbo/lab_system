package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.LabAdminDao;
import com.whut.lab.web.entity.LabAdmin;

@Repository("labAdminDao")
public class LabAdminDaoImpl extends BaseDaoImpl<LabAdmin, Integer> implements LabAdminDao{

}
