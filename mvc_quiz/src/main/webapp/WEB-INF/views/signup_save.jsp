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
	<c:choose>
		<c:when test="${result == 1}">
			<script type="text/javascript">
				alert("가입 완료")
				location.href="${contextPath}/index";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("가입 불가능")
				location.href="${contextPath}/index";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>