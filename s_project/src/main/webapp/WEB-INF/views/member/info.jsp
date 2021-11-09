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
		<h1>${info.id } 정 보</h1>
		<h3>아이디 : ${info.id }</h3>
		<h3>비밀번호 : ${info.pw }</h3>
		<h3>주소 : ${info.addr }</h3>
	</div>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>