package com.whut.lab.web.service;

import java.util.List;

import com.whut.lab.web.entity.Score;

public interface ScoreService extends BaseService<Score, Integer>{

	/**
	 * 根据学生id获取实验成绩记录
	 * @param studentId
	 * @return
	 */
	public List<Score> getByStudentId(int studentId);
	
	public List<Score> getByStudentId(int studentId, int current, int size);
	
	public long getCountByStudentId(int studentId);
}
