package com.zerock.database;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class mybatisTest {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testFactory() {
		System.out.println("sql팩토리 확인 : " + sqlFactory);
		System.out.println("-------------------------");
		System.out.println("dataSource 확인 : " + dataSource);
	}

}
