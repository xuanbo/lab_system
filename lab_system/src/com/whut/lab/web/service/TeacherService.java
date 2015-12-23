package com.whut.lab.web.service;

import java.util.List;

import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.model.TeacherInfo;

public interface TeacherService extends BaseService<Teacher, Integer>{

	public List<TeacherInfo> getTeacherInfo(int id);
	
	public List<TeacherInfo> getByPage(int id, int current, int size);
}
