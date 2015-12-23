package com.whut.lab.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.TeachProgramDao;
import com.whut.lab.web.entity.TeachProgram;

@Repository("teachProgramDao")
public class TeachProgramDaoImpl extends BaseDaoImpl<TeachProgram, Integer> implements TeachProgramDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<TeachProgram> getByMajorClassId(int majorClassId) {
		String hql = "select tp from MajorClass mc join mc.teachPrograms tp where mc.id=? order by tp.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TeachProgram> getByMajorClassId(int majorClassId, int current,
			int size) {
		String hql = "select tp from MajorClass mc join mc.teachPrograms tp where mc.id=? order by tp.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		query.setFirstResult((current - 1) * size);
		query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long getByMajorClassIdCount(int majorClassId) {
		String hql = "select count(*) from MajorClass mc join mc.teachPrograms tp where mc.id=? order by tp.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		return (long) query.uniqueResult();
	}

}
