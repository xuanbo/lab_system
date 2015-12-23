package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.LabClassDao;
import com.whut.lab.web.entity.LabClass;

@Repository("labClassDao")
public class LabClassDaoImpl extends BaseDaoImpl<LabClass, Integer> implements LabClassDao{

}
