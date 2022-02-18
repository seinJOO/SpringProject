package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.BoardVO;
import com.zerock.service.BoardService;
import com.zerock.service.BoardServiceImpl;

@Controller
@RequestMapping("/service") // = "/service/*"
public class BoardServiceController {
	
	// 1) 직접 객체 생성하여 연결하기 -- new BoardService 객체 생성
		BoardService boardService = new BoardServiceImpl();
	
	// 화면처리 - 게시판 등록
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		return "service/boardRegister";
	}
	
	// 게시판 등록 처리
	@RequestMapping("/boardForm")
	public String boardForm(
			@RequestParam("name") String name,
			@RequestParam("title") String title,
			@RequestParam("content") String content ) {

		boardService.register(name, title, content);
		
		return "service/boardResult";
	}
	
	// 화면처리 + 처리 - 게시글 리스트 보기
	@RequestMapping("/boardList") 
	public String boardList(Model model) {
		ArrayList<BoardVO> DB = boardService.getList();
		model.addAttribute("boardList",DB);
		return "service/boardList";
	}
	
	// 화면 + 삭제처리 - 게시글 삭제
	@RequestMapping("/boardDelete")
	public String boardDelete(@RequestParam("num") String num) {
		boardService.delete(num);
		return "redirect:/service/boardList";
	}
	
	
}
