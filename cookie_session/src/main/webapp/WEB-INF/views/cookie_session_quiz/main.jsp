<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>cookie_session_quiz/main.jsp<hr>
	<c:choose>
		<c:when test="${id != null }">
			${nick }님 안녕하세요.<br>
			만나서 반갑습니다.<br>
			<a href="logout">로그아웃</a>
			<a href="login">로그인 페이지 이동</a>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("로그인을 먼저 해주세요.")
				location.href="login"
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>