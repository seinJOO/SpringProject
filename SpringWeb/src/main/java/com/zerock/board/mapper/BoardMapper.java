package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;

public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);
	public ArrayList<BoardVO> getList();
	public BoardVO getContent(int num);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int num);
	public int getTotal();
	
	// 페이징 쿼리
	public ArrayList<BoardVO> pagingList(Criteria cri);

}
