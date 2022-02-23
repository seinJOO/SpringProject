package com.zerock.database;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class DBconnect {
	
	@Autowired(required=true)
	JdbcTemplate jdbcTemplete;
	
	@Autowired
	DataSource dataSource;
	
	@Test
	public void testConnection() {	
		
		try {
			System.out.println("jdbc템플릿 확인 : " + jdbcTemplete);
			System.out.println("dataSource 확인 : " + dataSource);
			Connection conn = dataSource.getConnection();
			System.out.println("연결성공!!!!!");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

}
