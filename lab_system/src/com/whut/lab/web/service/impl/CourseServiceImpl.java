package com.whut.lab.web.service.impl;

import org.springframework.stereotype.Service;

import com.whut.lab.web.entity.Course;
import com.whut.lab.web.service.CourseService;

@Service("courseService")
public class CourseServiceImpl extends BaseServiceImpl<Course, Integer> implements CourseService{

}
