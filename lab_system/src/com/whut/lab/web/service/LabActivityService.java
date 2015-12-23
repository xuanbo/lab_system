package com.whut.lab.web.service;

import java.util.List;

import com.whut.lab.web.entity.LabActivity;

public interface LabActivityService extends BaseService<LabActivity, Integer>{

	/**
	 * 根据实验室的预约状态获取记录条数
	 * @param state
	 * @return
	 */
	public long getCount(String state);
	
	/**
	 * 根据实验室预约状态获取记录
	 * @param state
	 * @return
	 */
	public List<LabActivity> get(String state);
	
	public List<LabActivity> get(String state, int current, int size);
	
	/**
	 * 根据教师id和实验室预约状态获取实验室预约记录
	 * @param teacherId      教师id
	 * @param labActivityState    labActivity.state
	 * @return
	 */
	public List<LabActivity> get(int teacherId, String labActivityState);
	
	public List<LabActivity> get(int teacherId, String labActivityState, int current, int size);
	
	public long getCount(int teacherId, String labActivityState);
	
	/**
	 * 根据实验室id和实验室预约状态获取实验室预约记录
	 * @param labClssId
	 * @param labActivityState
	 * @return
	 */
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState);
	
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState, int current, int size);
	
	public long getByLabClassAndLabActivityStateCount(int labClssId,
			String labActivityState);
	
	public List<LabActivity> getByLabClassId(int labClassId);
	
	public List<LabActivity> getByLabClassId(int labClassId, int current, int size);
	
	public Long getByLabClassIdCount(int labClassId);
	
	
	/**
	 * 根据专业班级id和实验预约状态获取实验预约记录
	 * @param majorClassId
	 * @param labActivityState
	 * @return
	 */
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState);
	
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState, int current, int size);
	
	public long getByMajorClassIdAndLabActivityStateCount(
			int majorClassId, String labActivityState);
}
