<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>login.jsp<hr>
	${login }<br>
	${requestScope.login }<br>
	attr : <%= request.getAttribute("login") %><br>
	param : <%= request.getParameter("login") %><br>
</body>
</html>