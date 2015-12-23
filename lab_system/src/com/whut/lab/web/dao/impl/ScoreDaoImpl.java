package com.whut.lab.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.ScoreDao;
import com.whut.lab.web.entity.Score;

@Repository("scoreDao")
public class ScoreDaoImpl extends BaseDaoImpl<Score, Integer> implements ScoreDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> getByStudentId(int studentId) {
		String hql = "select score from Student s join s.scores score where s.id=? order by score.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, studentId);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Score> getByStudentId(int studentId, int current, int size) {
		String hql = "select score from Student s join s.scores score where s.id=? order by score.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, studentId);
		query.setFirstResult((current - 1) * size);
        query.setMaxResults(size);
		return query.list();
	}

	@Override
	public long getCountByStudentId(int studentId) {
		String hql = "select count(*) from Student s join s.scores score where s.id=? order by score.id desc";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, studentId);
		return (long) query.uniqueResult();
	}

}
