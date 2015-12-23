package com.whut.lab.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.LossEquipmentDao;
import com.whut.lab.web.entity.LossEquipment;

@Repository("lossEquipmentDao")
public class LossEquipmentDaoImpl extends BaseDaoImpl<LossEquipment, Integer> implements LossEquipmentDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<LossEquipment> getByEquipmentId(int equipmentId) {
		String hql = "select le from Equipment e join e.lossEquipments le "
				+ "where e.id=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, equipmentId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LossEquipment> getByEquipmentId(int equipmentId, int current,
			int size) {
		String hql = "select le from Equipment e join e.lossEquipments le "
				+ "where e.id=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, equipmentId);
		query.setFirstResult((current - 1) * size);
		query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long getCountByEquipmentId(int equipmentId) {
		String hql = "select count(*) from Equipment e join e.lossEquipments le "
				+ "where e.id=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, equipmentId);
		return (long) query.uniqueResult();
	}

}
