package com.whut.lab.web.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.whut.lab.web.dao.BaseDao;
import com.whut.lab.web.service.BaseService;

/**
 * @author xuan
 *
 * @param <T>       实体对象
 * @param <ID>      id
 */
public class BaseServiceImpl <T extends Serializable, ID extends Serializable> implements BaseService <T, ID>{
 
	@Autowired
	protected  BaseDao<T, ID> baseDao;
	

	@Override
	public void save(Object object) {
		baseDao.save(object);
	}

	@Override
	public void delete(Object object) {
		baseDao.delete(object);
	}

	@Override
	public void delete(ID id) {
		baseDao.delete(id);
	}

	@Override
	public void update(Object object) {
		baseDao.update(object);
	}

	@Override
	public T get(ID id) {
		return baseDao.get(id); 
	}

	@Override
	public List<T> getByName(String name) {
		return baseDao.getByName(name);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}

	@Override
	public List<T> getByCondition(String hql) {
		return baseDao.getByCondition(hql);
	}

	@Override
	public void batchDelete(ID[] ids) {
		baseDao.batchDelete(ids);
	}

	@Override
	public List<T> getByPage(int currentPage, int showNumber) {
		return baseDao.getByPage(currentPage, showNumber);
	}

	@Override
	public long getTotalCount() {
		return baseDao.getTotalCount();
	}

	@Override
	public List<T> getByPage(String hql, int currentPage, int showNumber) {
		return baseDao.getByPage(hql, currentPage, showNumber);
	}

	@Override
	public long getTotalCount(String hql) {
		return baseDao.getTotalCount(hql);
	}

}
