package com.zerock.database;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml")
public class mybatisInsert {
	
	@Autowired
	TestMapper mapper;
	
	@Test
	public void insert() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "JUnit테스트 제목");
		map.put("content", "JUnit테스트 내용");
		map.put("writer", "JUnit테스트 작성자");
		boolean result = mapper.insertBoard(map);
		System.out.println("insert 메서드 결과 : " + result);		
		
	}

}
