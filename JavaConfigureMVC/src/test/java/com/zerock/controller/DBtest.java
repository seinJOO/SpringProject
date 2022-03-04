package com.zerock.controller;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.config.RootConfig;
import com.zerock.testmapper.TestMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class}) //클래스를 불러서 설정으로 쓰겠다!(원래는 root-context.xml)
@Log4j		//logger객체로 생성해도 되고, lombok은 어노테이션으로도 사용 가능
public class DBtest {
	
	@Setter(onMethod_ = {@Autowired})
	private DataSource dataSource;
	
	@Test
	public void DataSourceTest() {
		try(Connection conn = dataSource.getConnection()) {
			log.info("====히카리 연결 확인====");
			log.info(conn);
		} catch (Exception e) {
				fail(e.getMessage());
		}
	}
	
	@Setter(onMethod_ = {@Autowired})
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void MyBatisConnectTest() {
		try(SqlSession session = sqlSessionFactory.openSession();
				Connection conn2 = session.getConnection()) {
			log.info("===마이바티스 연결 확인===");
			log.info(conn2);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Setter(onMethod_ = {@Autowired})
	private TestMapper testMapper;
	
	@Test
	public void testGetTime() {
		log.info("===매퍼 동작 확인===");
		log.info(testMapper.getClass().getName());
		log.info(testMapper.getTime()); // TestMapper의 getTime() 실행 결과
	}
	

}
