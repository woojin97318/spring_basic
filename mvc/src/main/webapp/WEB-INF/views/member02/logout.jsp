<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>member02/logout.jsp<hr>
	requestScope.logout : ${requestScope.logout }<br>
	logout(el) : ${logout }<br>
	attr : <%= request.getAttribute("logout") %><br>
	param : <%= request.getParameter("logout") %><br>
	<br>
	<a href="http://localhost:8085/root/index02">[기본 페이지]</a>
	<a href="http://localhost:8085/root/login02">[로그인 페이지]</a>
</body>
</html>