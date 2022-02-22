<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- service에서 점수 저장 결과 메서드를 만든 후 액션태그 사용 -->
	<!-- 현재 for문에 index를 알 수 있는 변수 num -->
	<h2>점수 등록 결과</h2>
	<c:forEach var="good" items="${scoreList }" varStatus="num">
		번호 : ${num.index + 1 }
		이름 : ${good.name }
		국어 : ${good.kor }
		영어 : ${good.eng }
		수학 : ${good.math }
		<input type="button" value="삭제" onclick="location.href='scoreDelete?num=${good.num}'"><br>
		<hr>
	</c:forEach>
	<br>
	<a href="1scoreRegister">점수 등록하러 가기</a>
	
</body>
</html>