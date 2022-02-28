package com.zerock.controller;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.mapper.BoardMapper;

// JUnit 버전 변경 : 4.7 -> 4.12 / spring-test 설치 : 메이븐을 통해 설치 

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class PagingTest {
	
	@Autowired
	BoardMapper mapper;
	
	@Test
	public void pagingTest() {
		
		System.out.println("======pagingTest======");
		
		Criteria cri = new Criteria();
		
		cri.setPageNum(2); // 2번페이지 클릭
		cri.setCount(5); // 5개씩 보기
		
		ArrayList<BoardVO> list = mapper.pagingList(cri);
		
		for(BoardVO vo : list) {
			System.out.println("게시물번호 : " + vo.getNum());
		}
		
	}
	
	@Test
	public void ceilTest() {
		System.out.println("======Ceil Test (페이지 당 글 5개 ver)=======");
		
		// 올림 함수 test
		System.out.println("ceil 확인 : " + Math.ceil(2.1));
		
		//5페이지 조회 시 화면의 페이지번호 : 1~5
		//6페이지 조회 시 화면의 페이지번호 : 6~10
		
		//끝 페이지 번호
		//공식 : (int)Math.ceil(페이지번호 / 5) * 5
		int end = (int)Math.ceil(3 / 5.0) * 5;
		System.out.println("3페이지 일 때 보여지는 끝번호 : " + end);
		//시작 페이지 번호
		// 공식 : 끝페이지 - 4
		int start = end - 4;
		System.out.println("5페이지 일떄 보여지는 시작번호 : "+ start);
		
		end = (int)Math.ceil(8 / 5.0) * 5;
		System.out.println("8페이지 일 때 보여지는 끝번호 : " + end);		
		start = end - 4;
		System.out.println("8페이지 일떄 보여지는 시작번호 : "+ start);
		
		// 총 게시글에 따라 보여져야 할 페이지 수
		// 공식 : Math.ceil(전체 게시글 수 * 1.0 / 5)
		int realEnd = (int)Math.ceil(18 * 1.0 / 5);
		System.out.println("전체 데이터가 25개 이하일 때 : " + realEnd);
	}

}
