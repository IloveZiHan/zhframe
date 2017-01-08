package com.zhoufeng.zhframe.service.org;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhoufeng.zhframe.entity.org.Organization;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestOrganizationService {

	@Resource
	private OrganizationService os;
	
	@Test
	public void testListOrganizationsByPid01() {
		assertTrue(os.listOrganizationsByPid(null).size() > 0);;
	}
	
	@Test
	public void testInsert01() {
		Organization org = new Organization();
		org.setPid(1);
		org.setName("测试");
		
		os.insert(org);
		assertNotNull(org.getId());
	}
}
