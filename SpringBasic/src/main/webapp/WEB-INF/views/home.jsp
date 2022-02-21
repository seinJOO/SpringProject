<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<!-- HomeController에서 model.addAttribute 해준 serverTime값을 사용 -->
<P>  The time on the server is ${serverTime}. </P>
<a href="service/member_ex00">member</a>
<a href="service/boardRegister">board</a>
<a href="service/1scoreRegister">score</a>
</body>
</html>
