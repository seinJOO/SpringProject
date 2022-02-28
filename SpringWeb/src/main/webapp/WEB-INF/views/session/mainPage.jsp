<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
	<h2>모두가 사용 가능한 메인 페이지 입니다</h2>
	<hr>
	<input type="button" class="btn btn-primary" value="로그인" onclick="location.href='loginPage'">
	<input type="button" class="btn btn-secondary" value="마이페이지" onclick="location.href='myPage'">
</body>
<%@ include file="../include/footer.jsp" %>
</html>