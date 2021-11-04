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
	member_list.jsp<hr>
	
	<table border="1">
		<tr>
			<th>아이디</th>
			<th>패스워드</th>
			<th>이름</th>
		</tr>
		<c:choose>
			<c:when test="${list.size() != 0 }"><!-- 데이터가 존재할 경우 -->
				<c:forEach var="member" items="${list }">
					<tr>
						<td>${member.id }</td>
						<td>${member.pwd }</td>
						<td>
							<a href="${contextPath }/member/memberInfo?id=${member.id }">
								${member.name }
							</a>
						</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<th colspan="3">데이터 없음</th>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr>
			<th colspan="3">
				<a href="${contextPath }/member/index">index 이동</a>
			</th>
		</tr>
	</table>
	
</body>
</html>