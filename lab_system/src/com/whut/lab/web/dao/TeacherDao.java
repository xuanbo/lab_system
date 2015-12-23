package com.whut.lab.web.dao;

import java.util.List;

import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.model.TeacherInfo;

public interface TeacherDao extends BaseDao<Teacher, Integer>{
	
	/**
	 * 根据教师id获取TeacherInfo类型的教师
	 * @param id
	 * @return
	 */
	public List<TeacherInfo> getTeacherInfo(int id);
	
	public List<TeacherInfo> getByPage(int id, int current, int size);
}
