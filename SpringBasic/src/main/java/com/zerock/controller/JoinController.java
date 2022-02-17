package com.zerock.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.command.JoinVO;
import com.zerock.service.JoinService;

@Controller
@RequestMapping("/service/*")
public class JoinController {
	
	@Autowired
	JoinService joinService;
	
	@RequestMapping("/memberJoin")
	public String memberJoin(JoinVO jvo, Model model, RedirectAttributes RA) {
		int result = joinService.idCheck(jvo);
		
		if (result == 1) {
			joinService.memberJoin(jvo);
			model.addAttribute("memberInfo",jvo);
			model.addAttribute("memberInfo",jvo);
			return "service/member_ex02";
		} else {
			RA.addFlashAttribute("msg","이미 존재하는 아이디입니다");
			return "redirect:/service/member_ex00";
		}
	}
	
	@RequestMapping("/memberLogin")
	public String memberLogin(JoinVO jvo, Model model, RedirectAttributes RA) {
		JoinVO vo = joinService.loginCheck(jvo);
		if (vo != null) {
			
			model.addAttribute("memberInfo",vo);
			return "service/member_mypage";
		} else {
			RA.addFlashAttribute("msg","아이디와 비밀번호를 확인하세요");
			return "redirect:/service/member_ex03";
		}
	}

}
