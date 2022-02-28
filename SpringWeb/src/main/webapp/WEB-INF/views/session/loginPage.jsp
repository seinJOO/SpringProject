<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
<%@ include file="../include/header.jsp" %>
<div class="row">
<div class="col-lg-12">
<div class="card">
<div class="card-header bg-primary text-white">로그인</div>
<div class="card-body">
<div class="form-group">
	<form action="sessionLogin" method="post">
		<input type="text" class="form-control" name="id" placeholder="아이디">
		<input type="password" class="form-control" name="pw" placeholder="비밀번호"><br>
		<input type="submit" class="btn btn-primary" value="로그인">
		<input type="button" class="btn btn-secondary" value="취소" onclick="location.href='mainPage'">
	<p style="color:red">${msg }</p>
	</form>	
</div>
</div>
</div>
</div>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
</html>