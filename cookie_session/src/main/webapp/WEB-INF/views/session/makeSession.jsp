<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	session/makeSession.jsp<hr>
	
	id : ${id }, ${sessionScope.id }<br>
	name : ${name }, ${sessionScope.name }<br>
	<hr>
	<a href="result_session">result_session</a>
	<a href="del_session">del_session</a>
</body>
</html>