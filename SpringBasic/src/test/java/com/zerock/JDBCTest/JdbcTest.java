package com.zerock.JDBCTest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;


public class JdbcTest {
	String url="jdbc:oracle:thin:@localhost:1521/XEPDB1";
	String user = "myjsp";
	String password = "myjsp";
	
	// src/test/java 폴더에는 자바클래스를 이용하여 여러 작업을 테스트할 용도로 사용됨
	// 실행은 Run as -> JUnitTest를 사용하여 실행
	// @Test 어노테이션을 사용하여 테스트할 메서드를 지정 (프로젝트레벨에서 JUnit test 실행 시 해당 어노테이션만 테스트 실행)
	@Test
	public void JdbcTests() {
		try {
			// jdbc드라이버 호출
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println(">>>> connection 객체 생성" + conn);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
