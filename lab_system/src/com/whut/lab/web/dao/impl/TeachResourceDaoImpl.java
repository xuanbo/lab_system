package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.TeachResourceDao;
import com.whut.lab.web.entity.TeachResource;

@Repository("teachResourceDao")
public class TeachResourceDaoImpl extends BaseDaoImpl<TeachResource, Integer> implements TeachResourceDao{

}
