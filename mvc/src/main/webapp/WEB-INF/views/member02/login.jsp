<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>member02/login.jsp<hr>
	requestScope.login : ${requestScope.login }<br>
	login(el) : ${login }<br>
	attr : <%= request.getAttribute("login") %><br>
	param : <%= request.getParameter("login") %><br>
	<br>
	<a href="http://localhost:8085/root/index02">[기본 페이지]</a>
	<a href="http://localhost:8085/root/logout02">[로그아웃 페이지]</a>
</body>
</html>