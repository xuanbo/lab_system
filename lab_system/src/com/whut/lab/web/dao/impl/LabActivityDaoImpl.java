package com.whut.lab.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.LabActivityDao;
import com.whut.lab.web.entity.LabActivity;

@Repository("labActivityDao")
public class LabActivityDaoImpl extends BaseDaoImpl<LabActivity, Integer> implements LabActivityDao{

	@Override
	public long getCount(String state) {
		String hql = "select count(*) from LabActivity la where la.state=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setString(0, state);
		//将long型的数据格式转化成int类型
		//return ((Number)query.uniqueResult()).intValue();
		return (long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> get(String state) {
		String hql = "from LabActivity la where la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setString(0, state);
	    return query.list();
	    /**
	     * 或者return super.getByCondition(String hql);
	     */
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> get(String state, int current, int size){
		String hql = "from LabActivity la where la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setString(0, state);
		query.setFirstResult((current - 1) * size);
		query.setMaxResults(size);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> get(int teacherId, String labActivityState) {
		String hql = "select la from Teacher t join t.labActivities la where t.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, teacherId);
		query.setString(1, labActivityState);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> get(int teacherId, String labActivityState,
			int current, int size) {
		String hql = "select la from Teacher t join t.labActivities la where t.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, teacherId);
		query.setString(1, labActivityState);
		query.setFirstResult((current - 1) * size);
	    query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long getCount(int teacherId, String labActivityState) {
		String hql = "select count(*) from Teacher t join t.labActivities la where t.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, teacherId);
		query.setString(1, labActivityState);
		return (long) query.uniqueResult();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState) {
		String hql = "select la from LabClass lc join lc.labActivitys la where lc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClssId);
		query.setString(1, labActivityState);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByLabClassAndLabActivityState(int labClssId,
			String labActivityState, int current, int size) {
		String hql = "select la from LabClass lc join lc.labActivitys la where lc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClssId);
		query.setString(1, labActivityState);
		query.setFirstResult((current - 1) * size);
	    query.setMaxResults(size);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByLabClassId(int labClassId) {
		String hql = "select la from LabClass lc join lc.labActivitys la where lc.id=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClassId);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByLabClassId(int labClassId, int current, int size) {
		String hql = "select la from LabClass lc join lc.labActivitys la where lc.id=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClassId);
		query.setFirstResult((current - 1) * size);
		query.setMaxResults(size);
		return query.list();
	}
	
	@Override
	public Long getByLabClassIdCount(int labClassId) {
		String hql = "select count(*) from LabClass lc join lc.labActivitys la where lc.id=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClassId);
		return (Long) query.uniqueResult();
	}

	@Override
	public long getByLabClassAndLabActivityStateCount(int labClssId,
			String labActivityState) {
		String hql = "select count(*) from LabClass lc join lc.labActivitys la where lc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, labClssId);
		query.setString(1, labActivityState);
		return (long) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState) {
		String hql = "select la from MajorClass mc join mc.labActivities la where mc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		query.setString(1, labActivityState);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LabActivity> getByMajorClassIdAndLabActivityState(
			int majorClassId, String labActivityState, int current, int size) {
		String hql = "select la from MajorClass mc join mc.labActivities la where mc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		query.setString(1, labActivityState);
		query.setFirstResult((current - 1) * size);
	    query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long getByMajorClassIdAndLabActivityStateCount(int majorClassId,
			String labActivityState) {
		String hql = "select count(*) from MajorClass mc join mc.labActivities la where mc.id=? and la.state=? order by la.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, majorClassId);
		query.setString(1, labActivityState);
		return (long) query.uniqueResult();
	}

}
