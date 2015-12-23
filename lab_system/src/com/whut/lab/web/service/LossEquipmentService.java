package com.whut.lab.web.service;

import java.util.List;

import com.whut.lab.web.entity.LossEquipment;

public interface LossEquipmentService extends BaseService<LossEquipment, Integer>{

	/**
	 * 通过器材id获取损耗记录
	 * @return
	 */
	public List<LossEquipment> getByEquipmentId(int equipmentId);
	
	public List<LossEquipment> getByEquipmentId(int equipmentId, int current, int size);
	
	public long getCountByEquipmentId(int equipmentId);
}
