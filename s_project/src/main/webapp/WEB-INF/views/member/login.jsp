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
	<c:import url="../default/header.jsp"/>
	
	<div align="center">
		<h1>로그인 페이지</h1>
		<form action="userChk" method="post">
			<input type="text" name="id" placeholder="ID"><br>
			<input type="password" name="pw" placeholder="PW"><br>
			<input type="submit" value="login">
			<button type="button" onclick="location.href='register'">회원가입</button>
		</form>
	</div>

	<c:import url="../default/footer.jsp"/>
</body>
</html>