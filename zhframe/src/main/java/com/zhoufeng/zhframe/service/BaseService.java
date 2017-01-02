package com.zhoufeng.zhframe.service;

import java.io.Serializable;

import javax.transaction.Transactional;

public interface BaseService<T> {

	@Transactional
	public void save(T t);
	
	@Transactional
	public void delete(Serializable id);
	
	@Transactional
	public void update(T t);
	
	public T get(Serializable id);
}
