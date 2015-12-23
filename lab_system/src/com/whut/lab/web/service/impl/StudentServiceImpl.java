package com.whut.lab.web.service.impl;

import org.springframework.stereotype.Service;

import com.whut.lab.web.entity.Student;
import com.whut.lab.web.service.StudentService;

@Service("studentService")
public class StudentServiceImpl extends BaseServiceImpl<Student, Integer> implements StudentService{

}
