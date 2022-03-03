<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="text" id="apple" value="주세인">
	<input type="text" id="melon" value="주세니">
	<input type="text" id="grape" value="쭈세니">
	
	<button onclick="check()">확인</button>
	
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
				//alert("화면 접속 시 바로 실행하는 기능 구현");	
	
		var msg = '${msg}';
		
		if (msg != '') {
			alert('${msg}');
		}		
	
		});
		
		function check() { //check함수가 엮인 버튼을 클릭했을 때 작동
		
			$.ajax({
				type : "post",
				url : "checkId",
				data : {
					"id" : "senny" //앞이 파라미터 값, 뒤가 DB의 value값
					},
				success : function(result) {
					alert("비동기 성공!");
				}
			})
		}
	/*	
		function check() {
			$("#apple").attr("type","password");
			$("#grape").focus();
			$("#melon").attr("value","쭈세"); // 값도 바꿀수있음
			var a = $("#melon").val();
			alert(a);
			//val() $("#아이디")
			//attr(속성,값)
			//attr(속성)
			//removeattr(속성)
			//focus()
			
			//$.ajax()는 key-value 형태로 데이터를 주고받는다
		}
		*/
	</script>
</body>
</html>