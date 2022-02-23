package com.zerock.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class mybatisSelect {
	
	@Autowired
	TestMapper mapper;
	
	@Test
	public void select() {
		String time = mapper.getTime();
		System.out.println("날짜 확인 : " + time);
		
	}

}
