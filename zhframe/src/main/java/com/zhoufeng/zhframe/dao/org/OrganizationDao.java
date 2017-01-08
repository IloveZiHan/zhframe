package com.zhoufeng.zhframe.dao.org;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.zhoufeng.zhframe.dao.BaseDao;
import com.zhoufeng.zhframe.entity.org.Organization;

@Repository
public class OrganizationDao extends BaseDao<Organization>{
	
	public List<Organization> listRootOrganizations() {
		return listOrganizationByPid(null);
	}
	
	public List<Organization> listOrganizationByPid(Integer pid) {
		List<Organization> organizations = new ArrayList<>();

		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Organization where pid = " + pid);
		
		organizations = query.list();
		
		return organizations;
	} 
}
