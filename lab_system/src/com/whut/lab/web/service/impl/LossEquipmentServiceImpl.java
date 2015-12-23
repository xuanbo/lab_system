package com.whut.lab.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.whut.lab.web.dao.LossEquipmentDao;
import com.whut.lab.web.entity.LossEquipment;
import com.whut.lab.web.service.LossEquipmentService;

@Service("lossEquipmentService")
public class LossEquipmentServiceImpl extends BaseServiceImpl<LossEquipment, Integer> implements LossEquipmentService{

	@Autowired
	@Qualifier("lossEquipmentDao")
	private LossEquipmentDao lossEquipmentDao;
	
	
	@Override
	public List<LossEquipment> getByEquipmentId(int equipmentId) {
		return lossEquipmentDao.getByEquipmentId(equipmentId);
	}

	@Override
	public List<LossEquipment> getByEquipmentId(int equipmentId, int current,
			int size) {
		return lossEquipmentDao.getByEquipmentId(equipmentId, current, size);
	}

	@Override
	public long getCountByEquipmentId(int equipmentId) {
		return lossEquipmentDao.getCountByEquipmentId(equipmentId);
	}

}
