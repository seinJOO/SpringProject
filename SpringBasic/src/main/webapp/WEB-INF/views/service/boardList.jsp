<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<hr>
	<table>
	<tr>
	<td>번호</td>
	<td>작성자</td>
	<td>제목</td>
	<td>비고</td>
	</tr>
	<c:forEach var="list" items="${boardList }" varStatus="num">
	<tr>
	<td>${num.index + 1 }</td>
	<td>${list.name }</td>
	<td>${list.title }</td>
	<td><input type="button" value="삭제" onclick="location.href='boardDelete?num=${list.num}'"></td>
	</tr>
	</c:forEach>
	</table>
	<a href="boardRegister">글 작성하기</a>
</body>
</html>