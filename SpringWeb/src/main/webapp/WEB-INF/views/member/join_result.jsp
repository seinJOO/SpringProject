<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <script>
	$(document).ready(
	function() {
		var msg = '${msg}';
		
		if (msg != '') {
			alert('${msg}');//화면에서 넘어온 msg를 받아서 경고창 띄우기
		}		
	}
	)
	</script>