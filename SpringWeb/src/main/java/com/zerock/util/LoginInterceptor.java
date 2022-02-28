package com.zerock.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
	<인터셉터(Interceptor)의 용도 및 예시>
	- 세부적인 보안 및 인증/인가 공통 작업
	- API 호출에 대한 로깅/감사
	- Controller로 넘겨주는 정보(데이터)의 가공
*/
public class LoginInterceptor extends HandlerInterceptorAdapter {
	// 1) 스프링에서 제공하는 HandlerInterceptorAdapter 클래스를 상속
	// 2) alt + shift + s 로 overriding method를 통해 3가지 메서드를 오버라이딩 처리
	
	// preHandle 메서드는 컨트롤러를 실행하기 전 요청을 가로채서 처리-  일반적으로 로그인, 세션 처리에 사용됨
	// preHandle에서 세션 처리를 했다면, 스프링 설정 파일(servlet-context.xml)에 <Interceptor> 태그를 사용 - 매핑 설정
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(); // request객체로부터 session 정보 불러옴
		String user_id = (String) session.getAttribute("user_id");
		if (user_id == null) {
			System.out.println("preHandle 동작============");
			response.sendRedirect("/MyWeb/session/loginPage"); // 세션값이 없다면 로그인페이지로
			return false; // -> 세션값이 없다면 핸들러 메서드를 실행한 후 Controller를 수행하지 않는다
		} else {
			return true; // -> 세션값이 있다면 핸들러 메서드를 실행한 후 Controller를 수행한다
		}
	}
	

	//postHandle은 preHandle에서 true를 리턴하여 컨트롤러를 실행할 때만 동작 
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle 동작============");
		//super.postHandle(request, response, handler, modelAndView);
	}

	// afterCompletion
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion 동작============");
		//super.afterCompletion(request, response, handler, ex);
	}
		
	
	
	

}
