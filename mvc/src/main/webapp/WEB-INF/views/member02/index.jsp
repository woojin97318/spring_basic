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
<body>member02/index.jsp<hr>
	requestScope.index : ${requestScope.index }<br>
	index(el) : ${index }<br>
	attr : <%= request.getAttribute("index") %><br>
	param : <%= request.getParameter("index") %><br>
	<br>
	<a href="login02">[로그인 페이지]</a>
	<a href="${contextPath }/logout02">[로그아웃 페이지]</a>
</body>
</html>