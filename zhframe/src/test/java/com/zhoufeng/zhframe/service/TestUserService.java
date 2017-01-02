package com.zhoufeng.zhframe.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhoufeng.zhframe.entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserService {

	@Resource
	private UserService userService;
	
	@Test
	public void testSave() {
		User user = new User();
		user.setName("中国");
		
		userService.save(user);
	}

}
