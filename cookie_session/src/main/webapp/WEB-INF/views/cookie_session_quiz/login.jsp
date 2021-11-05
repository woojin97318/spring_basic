<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>cookie_session_quiz/login.jsp<hr>
	<c:import url="/quiz/cookie"/>
	<c:choose>
		<c:when test="${id != null and nick != null }">
			${nick }님 로그인 상태 입니다<br>
			<a href="main">main 이동</a>
		</c:when>
		<c:otherwise>
			<form action="chkUser" method="post">
				<input type="text" name="id"><br>
				<input type="password" name="pwd"><br>
				<input type="submit" value="submit"><br>
			</form>
		</c:otherwise>
	</c:choose>
</body>
</html>