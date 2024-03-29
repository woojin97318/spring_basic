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
	<c:import url="../default/header.jsp"/>
	
	<c:choose>
		<c:when test="${loginUser == null }">
			<div align="center">
				<h1>Login</h1>
				<br>
				<form action="${contextPath }/userChk" method="post">
					<input type="text" name="id" placeholder="ID"><br>
					<input type="password" name="pw" placeholder="PW"><br>
					<input type="checkbox" name="autoLogin">자동 로그인&nbsp;&nbsp;					<input type="submit" value="login"><br>
					<button type="button" onclick="location.href='register'">회원가입</button>
				</form>
			</div>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("${loginUser}님 이미 로그인이 되어있습니다.")
				location.href="index"
			</script>
		</c:otherwise>
	</c:choose>

	<c:import url="../default/footer.jsp"/>
</body>
</html>