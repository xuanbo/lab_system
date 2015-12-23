package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.StudentDao;
import com.whut.lab.web.entity.Student;

@Repository("studentDao")
public class StudentDaoImpl extends BaseDaoImpl<Student, Integer> implements StudentDao{

}
