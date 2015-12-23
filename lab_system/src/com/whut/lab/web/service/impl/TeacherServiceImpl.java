package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.lab.web.dao.TeacherDao;
import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.model.TeacherInfo;
import com.whut.lab.web.service.TeacherService;

@Service("teacherService")
public class TeacherServiceImpl extends BaseServiceImpl<Teacher, Integer> implements TeacherService{

	@Autowired
	@Qualifier("teacherDao")
	private TeacherDao teacherDao;
	
	
	@Override
	public List<TeacherInfo> getTeacherInfo(int id) {
		return teacherDao.getTeacherInfo(id);
	}


	@Override
	public List<TeacherInfo> getByPage(int id, int current, int size) {
		return teacherDao.getByPage(id, current, size);
	}

}
