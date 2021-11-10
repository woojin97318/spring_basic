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
	
	<c:choose>
		<c:when test="${loginUser eq null }">
			<script type="text/javascript">
				alert("로그인후 접근 가능")
				location.href="login"
			</script>
		</c:when>
		<c:otherwise>
			<div align="center">
				<h1>회 원 정 보</h1>
				<table border="1">
					<tr>
						<th>아이디</th>
						<th>비밀번호</th>
						<th>주소</th>
					</tr>
					<c:choose>
						<c:when test="${memberList != null }">
							<c:forEach var="member" items="${memberList }">
								<tr>
									<th><a href="info?id=${member.id }">${member.id }</a></th>
									<th>${member.pw }</th>
									<th>${member.addr }</th>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="3">회원정보가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</div>
		</c:otherwise>
	</c:choose>
	
	<c:import url="../default/footer.jsp"/>
</body>
</html>