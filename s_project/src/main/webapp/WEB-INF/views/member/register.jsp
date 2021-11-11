<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${contextPath }/resources/js/daumpost.js"></script>
</head>
<body>
	<c:import url="../default/header.jsp"/>
	
	<div align="center">
		<h1>회 원 등 록</h1>
		<form id="fo" action="register_save" method="post">
			<input type="text" name="id" placeholder="아이디"><br>
			<input type="password" name="pw" placeholder="비밀번호"><br>
			<input type="text" readonly id="addr1" name="addr" placeholder="우편번호">
			<input type="button" onclick="daumPost()" value="우편번호 찾기"><br>
			<input type="text" readonly id="addr2" placeholder="주 소"><br>
			<input type="text" id="addr3" placeholder="상 세 주 소"><br>
			<input type="button" value="회원가입" onclick="register()"><br>
		</form>
	</div>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>