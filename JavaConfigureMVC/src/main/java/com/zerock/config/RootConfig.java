package com.zerock.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// root-context.xml의 역할을 대신할 클래스!!(DB 관련 작업)
// web.xml에서는 root-context 호출 -> loader -> 서블릿호출 -> 서블릿매핑 -> 필터 순서로 처리

@Configuration
@MapperScan(basePackages = {"com.zerock.testmapper"})	//mapper를 xml파일 없이 쓸 때 스캔해줌
public class RootConfig {
	
	//HikariCP 설정
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		hikariConfig.setUsername("spring");
		hikariConfig.setPassword("spring");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	
	//MyBatis 설정
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return sqlSessionFactory.getObject();				
	}

}
