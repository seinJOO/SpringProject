package com.zerock.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;
import com.zerock.dao.BoardDAO;
import com.zerock.dao.BoardDAOImpl;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDAO boardDAO;

	@Override
	public void register(String name, String title, String content) {
		System.out.println("---서비스계층---");
		System.out.println(name);
		System.out.println(title);
		System.out.println(content);
		
		// 호출
		boardDAO.boardInsert(name, title, content);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> DB = boardDAO.boardSelect();
		return DB;
	}

	@Override
	public void delete(String num) {
		boardDAO.boardDelete(num);

	}

}
