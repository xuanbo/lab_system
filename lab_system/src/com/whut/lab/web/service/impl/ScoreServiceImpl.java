package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.lab.web.dao.ScoreDao;
import com.whut.lab.web.entity.Score;
import com.whut.lab.web.service.ScoreService;

@Service("scoreService")
public class ScoreServiceImpl extends BaseServiceImpl<Score, Integer> implements ScoreService{

	@Autowired
	@Qualifier("scoreDao")
	private ScoreDao scoreDao;
	
	
	@Override
	public List<Score> getByStudentId(int studentId) {
		return scoreDao.getByStudentId(studentId);
	}

	@Override
	public List<Score> getByStudentId(int studentId, int current, int size) {
		return scoreDao.getByStudentId(studentId, current, size);
	}

	@Override
	public long getCountByStudentId(int studentId) {
		return scoreDao.getCountByStudentId(studentId);
	}

}
