package com.whut.lab.web.dao;

import java.util.List;

import com.whut.lab.web.entity.TeachProgram;

public interface TeachProgramDao extends BaseDao<TeachProgram, Integer>{

	/**
	 * 根据专业班级id获取教学计划
	 * @param majorClassId
	 * @return
	 */
	public List<TeachProgram> getByMajorClassId(int majorClassId);
	
	public List<TeachProgram> getByMajorClassId(int majorClassId, int current, int size);
	
	public long getByMajorClassIdCount(int majorClassId);
}
