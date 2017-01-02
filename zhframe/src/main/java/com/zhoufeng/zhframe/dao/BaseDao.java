package com.zhoufeng.zhframe.dao;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> {

	@Resource
	private SessionFactory sessionFactory;
	
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}
	
	public void delete(Serializable id, Class<T> clazz) {
		T t = get(id, clazz);
		if(t != null)
			sessionFactory.getCurrentSession().delete(t);
	}
	
	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}
	
	public T get(Serializable id, Class<T> clazz) {
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}
}
