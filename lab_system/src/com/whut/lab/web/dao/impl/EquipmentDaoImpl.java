package com.whut.lab.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.EquipmentDao;
import com.whut.lab.web.entity.Equipment;

@Repository("equipmentDao")
public class EquipmentDaoImpl extends BaseDaoImpl<Equipment, Integer> implements EquipmentDao{

}
