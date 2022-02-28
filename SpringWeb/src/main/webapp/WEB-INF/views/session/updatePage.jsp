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
<div class="row">
<div class="col-lg-12">
<div class="card">
<div class="card-header bg-primary text-white">회원 정보 수정</div>
<div class="card-body">
<div class="form-group">
	<form action="updatePage" method="post">
	<div class="form-group">
            <label>아이디</label>
            <input class="form-control" name="id" id="id" value="${sessionScope.user_id }" readonly>
    </div>
    <div class="form-group">
            <label>비밀번호</label>
            <input class="form-control" type="password" name="pw" id="pw">
    </div>
     <div class="form-group">
            <label>비밀번호 확인</label>
            <input class="form-control" type="password" name="pw" id="pw">
    </div>
    <div class="form-group">
            <label>이름</label>
            <input class="form-control" type="text" name="name" id="name" value="${sessionScope.user_name }">
    </div>
		<input type="button" class="btn btn-primary" value="변경하기" onclick="location.href='/updatePage'">
		<input type="button" class="btn btn-dark" value="취소" onclick="location.href='mainPage'">
	</form>
	<p style="color:red">${msg }</p>
</div>
</div>
</div>
</div>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
</html>