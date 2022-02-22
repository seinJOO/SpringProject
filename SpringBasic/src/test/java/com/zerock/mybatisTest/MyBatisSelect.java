package com.zerock.mybatisTest;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.command.ScoreVO;
import com.zerock.testmapper.TestMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MyBatisSelect {
	
	// 매퍼.xml에서 설정한 select태그를 활용하여 DAO인 것처럼 가정하여 작업한다
	// 마이바티스 매퍼(mapper) 스캔(root-context) & 매퍼 인터페이스 & 매퍼 XML이 있어야 동작함
	@Autowired
	private TestMapper mapper;	// 매퍼로 설정된 추상 인터페이스를 불러오기
	
	@Test
	public void select() {
		String time = mapper.getTime();
		System.out.println(time);
		
		ArrayList<ScoreVO> list = mapper.select();
		
		for(ScoreVO vo : list) {
			System.out.println(vo.getNum());
			System.out.println(vo.getName());
			System.out.println(vo.getKor());
			System.out.println(vo.getEng());
			System.out.println(vo.getMath());
			System.out.println("-----------------");
		}
	}
	
}
