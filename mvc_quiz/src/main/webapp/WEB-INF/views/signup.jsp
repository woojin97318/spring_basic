<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	signup.jsp<hr>
	
	<h1>회원가입 페이지</h1>
	<form action="${contextPath }/signup_save" method="post">
		<input type="text" name="id" placeholder="id"><br>
		<input type="password" name="pwd" placeholder="pwd"><br>
		<input type="text" name="name" placeholder="name"><br>
		<input type="submit" value="가입"><br>
	</form>
</body>
</html>