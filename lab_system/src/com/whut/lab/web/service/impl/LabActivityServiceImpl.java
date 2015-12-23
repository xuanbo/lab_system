package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.lab.web.dao.LabActivityDao;
import com.whut.lab.web.entity.LabActivity;
import com.whut.lab.web.service.LabActivityService;

@Service("labActivityService")
public class LabActivityServiceImpl extends BaseServiceImpl<LabActivity, Integer> implements LabActivityService{

	@Autowired
	@Qualifier("labActivityDao")
	private LabActivityDao labActivityDao;
	
	
	@Override
	public long getCount(String state) {	
		return labActivityDao.getCount(state);
	}


	@Override
	public List<LabActivity> get(String state) {
		return labActivityDao.get(state);
	}

	@Override
	public List<LabActivity> get(String state, int current, int size){
		return labActivityDao.get(state, current, size);
	}
	
	@Override
	public List<LabActivity> get(int teacherId, String labActivityState) {
		return labActivityDao.get(teacherId, labActivityState);
	}

	@Override
	public List<LabActivity> get(int teacherId, String labActivityState,
			int current, int size) {
		return labActivityDao.get(teacherId, labActivityState, current, size);
	}
	
	@Override
	public long getCount(int teacherId, String labActivityState) {
		return labActivityDao.getCount(teacherId, labActivityState);
	}


	@Override
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState) {
		return labActivityDao.getByLabClassAndLabActivityState(labClssId, labActivityState);
	}
	
	@Override
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState, int current, int size) {
		return labActivityDao.getByLabClassAndLabActivityState(labClssId, labActivityState, current, size);
	}


	@Override
	public long getByLabClassAndLabActivityStateCount(int labClssId,
			String labActivityState) {
		return labActivityDao.getByLabClassAndLabActivityStateCount(labClssId, labActivityState);
	}
 
	@Override
	public List<LabActivity> getByLabClassId(int labClassId){
		return labActivityDao.getByLabClassId(labClassId);
	}
	
	@Override
	public List<LabActivity> getByLabClassId(int labClassId, int current, int size){
		return labActivityDao.getByLabClassId(labClassId, current, size);
	}
	
	@Override
	public Long getByLabClassIdCount(int labClassId){
		return labActivityDao.getByLabClassIdCount(labClassId);
	}

	@Override
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState) {
		return labActivityDao.getByMajorClassIdAndLabActivityState(majorClassId, labActivityState);
	}


	@Override
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState, int current, int size) {
		return labActivityDao.getByMajorClassIdAndLabActivityState(majorClassId, labActivityState, current, size);
	}


	@Override
	public long getByMajorClassIdAndLabActivityStateCount(int majorClassId,
			String labActivityState) {
		return labActivityDao.getByMajorClassIdAndLabActivityStateCount(majorClassId, labActivityState);
	}

}
