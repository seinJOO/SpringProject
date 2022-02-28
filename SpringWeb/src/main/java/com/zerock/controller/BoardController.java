package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.board.command.BoardVO;
import com.zerock.board.command.Criteria;
import com.zerock.board.command.PageVO;
import com.zerock.board.service.BoardService;

/*
	1. controller 구현(뷰 작업)
	2. 테이블 생성(더미 데이터 작업)
	3. DB 관련 설정테스트 (root-context.xml 작업 후 테스트)
	4. BoardVO 생성(DB의 컬럼명으로 동일하게 생성)
	5. Service 구현
	6. DAO 구현 - hikariCP로 연동, JdbcTemplate으로
	
	* get방식의 매핑 
	  -> @RequestMapping(value="/register",method=RequestMethod.GET)
 
*/

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	// GET 방식의 매핑
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(Criteria cri, Model model) {
		model.addAttribute("cri", cri);
		return "board/register";
	}
	
	// POST 방식의 매핑
	@RequestMapping(value="/boardForm", method = RequestMethod.POST)
	public String register(BoardVO vo) {		
		service.regist(vo);	// 서비스 처리		
		return "redirect:/board/list";
	}
/*
	@RequestMapping("/list")
	public String boardList(Model model) { // DB의 모든 값을 가지고 화면으로 이동
		ArrayList<BoardVO> list = service.getList();
		model.addAttribute("list",list);
		return "board/list";
	}
*/
	
	// 페이징 화면 처리
	@RequestMapping("/list")
	public String list(Model model, Criteria cri) {
		//게시글 정보 가져오기
		int total = service.getTotal();
		ArrayList<BoardVO> list = service.getList(cri);
		model.addAttribute("list", list);
		model.addAttribute("pageMaker", new PageVO(total, cri));
		return "board/list";
	}
	
	
	@RequestMapping("/viewContent")
	public String boardContent(@RequestParam("num") int num, @RequestParam("index") String index, Model model, @ModelAttribute("cri") Criteria cri) { 
		BoardVO vo = service.getContent(num);
		model.addAttribute("index",index);
		model.addAttribute("vo",vo);
		model.addAttribute("cri", cri);
		return "board/content";
	}	
	

	@RequestMapping("/modify")
	public String modify(@RequestParam("num") int num, @RequestParam("index") String index, Model model, @ModelAttribute("cri") Criteria cri) {		
		BoardVO vo = service.getContent(num);
		model.addAttribute("vo",vo);
		model.addAttribute("index",index);
		model.addAttribute("cri", cri);
		return "board/modify";
	}

	@RequestMapping("/modifyForm")
	public String modifyForm(@RequestParam("index") String index, BoardVO vo, @ModelAttribute("cri") Criteria cri, Model model) {
		service.update(vo);
		model.addAttribute("vo",vo);
		model.addAttribute("index",index);
		model.addAttribute("cri", cri);
		return "board/content";
	}
	
	@RequestMapping("/contentDelete")
	public String contentDelete(@RequestParam("num") String num) {
		service.delete(Integer.parseInt(num));
		return "redirect:/board/list";
	}
	
	
	
	
}
