package com.zerock.mybatisTest;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisInsert {
	
	@Autowired
	private TestMapper mapper;
	
	@Test
	public void insert() {		
		// SQLException 발생을 방지하기 위해 try-catch 활용
		try {			
			// VO에 값 넣기
			ScoreVO vo = new ScoreVO("화요일", "20", "30", "40");		
			boolean result = mapper.insert(vo);
			System.out.println("데이터 삽입 성공 ? : "+result);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	public void insert2() {
		try {			
			Map<String, String> map = new HashMap<>();
			map.put("p1", "점심전");
			map.put("p2", "90");
			map.put("p3", "80");
			map.put("p4", "70");			
			boolean result = mapper.insert2(map);
			System.out.println("map을 이용한 myBatis 성공 ? : " + result);			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}
