package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zerock.member.command.MemberVO;
import com.zerock.member.service.MemberService;
import com.zerock.member.service.MemberServiceImpl;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	MemberService member;
	
	//회원가입 화면 처리
		@RequestMapping("/join")
		public String join() {
			return "member/join";			
	  }
		
		//회원가입 처리
		@RequestMapping("/joinForm")       //RedirectAttributes 
		public String joinForm(MemberVO vo, RedirectAttributes RA) {
			
			//service로 join작업을 처리해야함.
			int result = member.join(vo);
			if(result==1) { //1 반환받았다는것은 insert성공
				RA.addFlashAttribute("msg","회원가입에 성공했습니다.");
				
			}else {
				RA.addFlashAttribute("msg","회원가입에 실패했습니다.");
			}
			//return "redirect:/member/login"; //로그인 컨트롤러로 보낸다.
			return "redirect:/member/join_result";
		}
		
		@RequestMapping("/join_result")
		public String join_result(RedirectAttributes RA) {
			RA.getFlashAttributes();
			return "member/login";
		}
		
		@RequestMapping("/login")
		public String login() {
			return "member/login";			
	  }
		
		// login 폼 처리 - 인증, 세션, 성공 => "/" 실패 => "login"
		@RequestMapping("/loginForm")
		public String loginForm(MemberVO vo, HttpSession session, RedirectAttributes RA) {
			
			int result = member.login(vo);			
			if (result == 1) {
				session.setAttribute("user_id", vo.getId());
				return "redirect:/";	//홈컨트롤러로 리턴
			} else return "redirect:/member/login";
			
		}
	

}
