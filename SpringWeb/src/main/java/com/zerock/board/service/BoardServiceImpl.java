package com.zerock.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;
import com.zerock.board.mapper.BoardMapper;

// Service 어노테이션
// 스프링에서 DispatcherServlet이 동작하고, HandlerAdaptor가 가동되면 해당 어노테이션을 확인 -> 빈으로 등록 생성
// 수동으로 bean 등록을 하지 않았다면, servlet-context.xml에서 component-scan을 해야함
@Service
public class BoardServiceImpl implements BoardService {
	

	@Autowired
	BoardMapper mapper;

	@Override
	public ArrayList<BoardVO> getList(Criteria cri) {
		ArrayList<BoardVO> vo = mapper.pagingList(cri);
		return vo;
	}
	

	@Override
	public int getTotal() {
		int total = mapper.getTotal();
		return total;
	}



	@Override
	public void regist(BoardVO vo) {
		mapper.insertBoard(vo);		
	}

	@Override
	public BoardVO getContent(int num) {
		BoardVO vo = mapper.getContent(num);
		return vo;
	}

	@Override
	public void update(BoardVO vo) {
		mapper.updateBoard(vo);
	}

	@Override
	public void delete(int num) {
		mapper.deleteBoard(num);
	}
/*
	//	페이징 처리 전 getList
	@Override
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> list = mapper.getList();
		return list;
	}	
*/
	

}
