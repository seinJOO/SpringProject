package com.zerock.board.service;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;

public interface BoardService {
	
	//public ArrayList<BoardVO> getList();	//리스트 메서드
	public ArrayList<BoardVO> getList(Criteria cri);
	public int getTotal();
	public void regist(BoardVO vo);			//등록 메서드
	public BoardVO getContent(int num);		//상세보기 메서드(반환유형 고려해서 생성하기) => (getList에서 num값으로 arraylist에서 vo골라내기-> boardvo로 반환)
	public void update(BoardVO vo);
	public void delete(int num);			//게시물 삭제
	

}
