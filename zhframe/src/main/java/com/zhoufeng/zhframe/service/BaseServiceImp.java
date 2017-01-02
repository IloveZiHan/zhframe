package com.zhoufeng.zhframe.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.annotation.Resource;

import com.zhoufeng.zhframe.dao.BaseDao;

public class BaseServiceImp<T> implements BaseService<T>{

	@Resource
	private BaseDao<T> baseDao;
	private Class<T> clazz;
	
	public BaseServiceImp() {
		Class clazz = getClass();
		
		Type type = clazz.getGenericSuperclass();
		if(type instanceof ParameterizedType) {
			ParameterizedType pType = (ParameterizedType)type;
			this.clazz = (Class<T>)pType.getActualTypeArguments()[0];
		}
	}
	
	@Override
	public void save(T t) {
		baseDao.save(t);
	}
	
	@Override
	public void delete(Serializable id) {
		baseDao.delete(id, clazz);
	}
	
	@Override
	public void update(T t) {
		baseDao.update(t);
	}
	
	@Override
	public T get(Serializable id) {
		return baseDao.get(id, clazz);
	}
}
