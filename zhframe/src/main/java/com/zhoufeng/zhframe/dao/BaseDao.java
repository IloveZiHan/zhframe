package com.zhoufeng.zhframe.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T>{

	@Resource
	protected SessionFactory sessionFactory;

	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}

	public void delete(Serializable id, Class<T> clazz) {
		T t = get(id, clazz);
		if (t != null)
			sessionFactory.getCurrentSession().delete(t);
	}

	public void update(T t) {
		sessionFactory.getCurrentSession().update(t);
	}

	public T get(Serializable id, Class<T> clazz) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}
	
	public List<T> listAll() {
		Type genType = getClass().getGenericSuperclass();   
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();   
		Class clazz =  (Class)params[0];  
		Query q = sessionFactory.getCurrentSession().createQuery("from " + clazz.getName());
		
		return q.list();
	}
}
