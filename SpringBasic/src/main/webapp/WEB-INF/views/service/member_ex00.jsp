<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 회원 가입 (화면 URL요청 : con_path/service/member_tx01) </h2>
	<p style="color:red">${msg }</p><br>
	<form action="memberJoin" method="post">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		Name : <input type="text" name="name"><br><br>
		Address : <input type="text" name="addr"><br><br>
		Phone : <input type="text" name="phone"><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>
<!-- 
	1. join의 매핑을 처리할 수 있는 매서드 생성 (controller)
	2. command 패키지에 parameter 값을 처리할 수 있는 커맨드객체 JoinVO를 생성해서 값을 받아 처리
		(멤버변수는 ID, PW, NAME ... )
	3. service 패키지에 JoinService 인터페이스와 JoinService를 구현하는 JoinServiceImpl클래스 생성
	4. JoinServiceImpl을 어노테이션을 이요하여 자동 객체 생성 = @Service(이름)
	5. 컨트롤러의 멤버변수로 해당 객체를 자동의존주입 @Autowired
 -->