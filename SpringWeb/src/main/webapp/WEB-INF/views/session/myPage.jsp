<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../include/header.jsp" %>
</head>
<body>
</body>
<h2>마이페이지</h2>
<h3>${sessionScope.user_name }님 로그인을 환영합니다</h3>

<input type="button" class="btn btn-primary" value="정보수정" onclick="location.href='updatePage'">
<input type="button" class="btn btn-secondary" value="취소" onclick="location.href='mainPage'">
<input type="button" class="btn btn-dark" value="로그아웃" onclick="location.href='logout'">

<%@ include file="../include/footer.jsp" %>
</html>