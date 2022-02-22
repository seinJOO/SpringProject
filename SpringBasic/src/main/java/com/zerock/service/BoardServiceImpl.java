package com.zerock.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zerock.command.BoardVO;
import com.zerock.dao.BoardDAO;
import com.zerock.dao.BoardDAOImpl;
import com.zerock.mapper.BoardMapper;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	//BoardDAO boardDAO;

	@Override
	public void register(String name, String title, String content) {
		
		// 1) 커맨드 객체 이용
/*		BoardVO vo = new BoardVO(name, title, content);	
		mapper.insert(vo);
*/
		//2) Map 타입으로 이용 - 여러개의 값을 전달할 때 사용한 key값이 마이바티스 전달에 사용될 값이 된다
		Map<String, String> map = new HashMap<String, String>();
		map.put("p1", name);
		map.put("p2", title);
		map.put("p3", content);
		
		mapper.insert(map);
		
		// boardDAO.boardInsert(name, title, content);
	}

	@Override
	public ArrayList<BoardVO> getList() {
		ArrayList<BoardVO> vo = mapper.select();
		// ArrayList<BoardVO> DB = boardDAO.boardSelect();
		return vo;
	}

	@Override
	public void delete(String num) {
		mapper.delete(num);
		//boardDAO.boardDelete(num);

	}

}
