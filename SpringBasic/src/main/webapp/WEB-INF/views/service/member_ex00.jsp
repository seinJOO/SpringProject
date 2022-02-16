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

	<form action="join" method="post">
		ID : <input type="text" name="id"><br><br>
		PW : <input type="password" name="pw"><br><br>
		Name : <input type="text" name="name"><br><br>
		Address : <input type="text" name="addr"><br><br>
		Phone : <input type="text" name="phone"><br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>