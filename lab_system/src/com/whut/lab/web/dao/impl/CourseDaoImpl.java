package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.CourseDao;
import com.whut.lab.web.entity.Course;

@Repository("courseDao")
public class CourseDaoImpl extends BaseDaoImpl<Course,Integer> implements CourseDao{

}
