package com.zerock.board.mapper;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.zerock.board.command.BoardVO;
import com.zerock.util.PageVO;

public interface BoardMapper {
	
	public void insertBoard(BoardVO vo);
	public ArrayList<BoardVO> getList();
	public BoardVO getContent(int num);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(int num);

}
