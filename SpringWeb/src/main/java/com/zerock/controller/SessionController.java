package com.zerock.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// 세션 연습

@Controller
@RequestMapping("/session/*")
public class SessionController {
	
	// 1) main화면 처리 (mainPage)
	@RequestMapping("/mainPage")
	public String mainPage() {		
		return "session/mainPage";
	}
	
	// 2) 로그인 화면 처리 (loginPage)
	@RequestMapping("/loginPage") 
	public String loginPage(HttpSession session) {		
		if (session.getAttribute("user_id") == null) {
			return "session/loginPage";
		} else
		return "session/myPage";
	}	
	
	// 3) 마이페이지 화면 처리 (myPage)
	@RequestMapping(value = "/myPage", method = RequestMethod.GET)
	public String myPage(HttpSession session) {
/* 		7) 마이페이지 접근 막기 - 세션 아이디가 없으면 로그인 페이지로 이동
 					***=> 8-1) 인터셉터 설정하여 LoginInterceptor에서 이미 동작 구현함
		if (session.getAttribute("user_id") == null) {
			return "redirect:/session/loginPage";
		} 
*/			return "session/myPage";
	}
	
	// 4) 정보 수정 페이지
	@RequestMapping(value="/updatePage", method = RequestMethod.GET)
	public String updateInfo() {
		// 8-2) 세션 아이디 없을 경우 인터셉터를 사용하여 접근 차단 (servlet.xml에 태그 추가 / 여러 페이지 한번에 적용 가능)
		return "session/updatePage";
	}
	
	// 5) 로그인 폼 처리
	@RequestMapping("/sessionLogin")
	public String sessionLogin(@RequestParam("id") String id, @RequestParam("pw") String pw,
								HttpSession session, RedirectAttributes RA) {
		
		if (id.equals("abc") && pw.equals("1234")) {
			//로그인 성공 시 인증 값 생성 -> myPage로 이동
			session.setAttribute("user_id", id); // 세션에 아이디 저장
			session.setAttribute("user_name", "세니");
			return "redirect:/session/myPage";
		} else {
			// 9) 실패 시 1회성 데이터로 파라미터 값 전달 & 리다이렉트로 다시 로그인 요청
			RA.addFlashAttribute("msg", "아이디와 비밀번호를 다시 확인해주세요");
			return "redirect:/session/loginPage";
		}
	}
	
	// 6) 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.removeAttribute("user_id");
		session.invalidate();
		return "redirect:/session/mainPage";
	}
	
}
