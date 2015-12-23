package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.lab.web.dao.TeachProgramDao;
import com.whut.lab.web.entity.TeachProgram;
import com.whut.lab.web.service.TeachProgramService;

@Service("teachProgramService")
public class TeachProgramServiceImpl extends BaseServiceImpl<TeachProgram, Integer> implements TeachProgramService{

	@Autowired
	@Qualifier("teachProgramDao")
	private TeachProgramDao teachProgramDao;
	
	@Override
	public List<TeachProgram> getByMajorClassId(int majorClassId) {
		return teachProgramDao.getByMajorClassId(majorClassId);
	}

	@Override
	public List<TeachProgram> getByMajorClassId(int majorClassId, int current,
			int size) {
		return teachProgramDao.getByMajorClassId(majorClassId, current, size);
	}

	@Override
	public long getByMajorClassIdCount(int majorClassId) {
		return teachProgramDao.getByMajorClassIdCount(majorClassId);
	}

}
