package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.MajorClassDao;
import com.whut.lab.web.entity.MajorClass;

@Repository("majorClassDao")
public class MajorClassDaoImpl extends BaseDaoImpl<MajorClass, Integer> implements MajorClassDao{

}
