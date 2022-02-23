package com.zerock.board.mapper;

import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.util.PageVO;

public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);
	public ArrayList<BoardVO> getList();
	public BoardVO getContent(String num);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int num);
	public int getTotal();

}
