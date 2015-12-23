package com.whut.lab.web.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.whut.lab.web.dao.TeacherDao;
import com.whut.lab.web.entity.Teacher;
import com.whut.lab.web.model.TeacherInfo;

@Repository("teacherDao")
public class TeacherDaoImpl extends BaseDaoImpl<Teacher, Integer> implements TeacherDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<TeacherInfo> getTeacherInfo(int id) {
		String hql = "select distinct new com.whut.lab.web.model.TeacherInfo(c.name,m.name) "
				+ "from Teacher t join t.courses c left join t.majorClasses m "
				+ "where t.id=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, id);
		return query.list();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TeacherInfo> getByPage(int id, int current, int size){
		String hql = "select distinct new com.whut.lab.web.model.TeacherInfo(c.name,m.name) "
				+ "from Teacher t join t.courses c left join t.majorClasses m "
				+ "where t.id=?";
		Query query = super.getHibernateSession().createQuery(hql);
		query.setInteger(0, id);
		query.setFirstResult((current - 1) * size);
	    query.setMaxResults(size);
		return query.list();
	}

}
