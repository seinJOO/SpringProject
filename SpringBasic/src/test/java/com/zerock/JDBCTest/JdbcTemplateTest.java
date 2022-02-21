package com.zerock.JDBCTest;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 독립 실행을 위한 환경 설정 (얘가 실행되는 동안은 다른 작업 X)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class JdbcTemplateTest {
/*	테스트 실행 시 주의점
	1) spring-test 라이브러리가 추가되어 있어야 테스트 실행 가능
	2) Run As->JUnitTest 실행  <= @Test 어노테이션으로 JUnit 사용
*/
	@Autowired
	DataSource datasource;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Test
	public void testTemplate() {
		try {
			Connection conn = datasource.getConnection();
			System.out.println(">>>>>>> connection 출력 : " + conn);
			
			System.out.println(">>>>>>> 템플릿 객체 생성 : " + jdbcTemplate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
