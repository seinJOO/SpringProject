package com.zerock.controller;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zerock.command.ScoreVO;
import com.zerock.service.ScoreService;
import com.zerock.service.ScoreServiceImpl;

@Controller
@RequestMapping("/service/*")
public class ScoreServiceController {
	
	/*	객체생성
	 	1) new연산자를 이용
			ScoreService scoreService = new ScoreServiceImpl();
		2) servlet-context에 설정하여 자동 주입
			@Resource(name="ScoreService")
			ScoreService scoreService;	/	<beans:bean id="ScoreService" class="com.zerock.service.ScoreServiceImpl"></beans:bean>
		3) 어노테이션(repository + resource)를 이용한 자동 주입	*/
			@Autowired
			ScoreService scoreService;
	
	// 화면처리 - 점수 등록 화면으로
	@RequestMapping("/1scoreRegister")
	public String score() {
		return "service/1scoreRegister";
	}
	
	
	// 점수 등록 메서드
	@RequestMapping("scoreForm")
	public String scoreForm(ScoreVO vo) {
		scoreService.scoreRegist(vo); 	// 정수 등록
		return "service/2scoreResult";	// 뷰리졸버를 통해서 강제이동
	}
	
	// 점수 리스트
	@RequestMapping("/3scoreList")
	public String scoreList(Model model) {
		// 결과 반환 메서드
		// 메서드의 파라미터에 model을 추가하여 model에 list를 저장하여 전달(화면에서 사용 가능하도록)		
		ArrayList<ScoreVO> scoreList = scoreService.scoreResult();
		model.addAttribute("scoreList",scoreList);		
		return "service/3scoreList";
	}
	
	// 점수 삭제 (인덱스를 get방식으로 전달받기)
	@RequestMapping("/scoreDelete")
	public String scoreDelete(@RequestParam("num") String num) {
		scoreService.scoreDelete(num);
		return "redirect:/service/3scoreList";
		// return "service/3scoreList"로 이동할 시 view로 바로 들어가기 때문에 list값을 가지고 가지 못함! 
		// redirect를 통해 다시 컨트롤러로 이동하여 점수 리스트 메서드로 접속할 수 있도록 함!!!
	}
	
	
}
