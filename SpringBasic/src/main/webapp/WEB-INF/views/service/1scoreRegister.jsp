<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>점수 입력 (화면 URL 요청 : /service/1scoreRegister)</h2>
	<form action="scoreForm" method="post">
		이름 : <input type="text" name="name"><br><br>
		국어 : <input type="text" name="kor"><br><br>
		영어 : <input type="text" name="eng"><br><br>
		수학 : <input type="text" name="math"><br><br>
		<input type="submit" value="전송">
		<input type="button" value="목록" onclick="location.href='3scoreList'">
	</form>
</body>
</html>