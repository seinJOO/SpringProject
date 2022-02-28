package com.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	// 테이블 tbl_member 생성 (id, pw, name, regdate)
	@RequestMapping("/login")
	public String login() {
		
		return "member/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		
		return "member/join";
	}
	

}
