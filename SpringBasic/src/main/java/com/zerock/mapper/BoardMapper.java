package com.zerock.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.command.BoardVO;

public interface BoardMapper {
	
	//public void insert(BoardVO vo);		// Map<String, String> map으로 값 전달도 가능
	public void insert(Map<String, String> map);
	public ArrayList<BoardVO> select();
	public void delete(String num);

}
