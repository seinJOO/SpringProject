package com.zerock.testmapper;

import java.util.ArrayList;
import java.util.Map;

import com.zerock.board.command.BoardVO;

public interface TestMapper {

	public String getTime();
	public boolean insertBoard(Map<String, String> map);
	public ArrayList<BoardVO> getList();
}
