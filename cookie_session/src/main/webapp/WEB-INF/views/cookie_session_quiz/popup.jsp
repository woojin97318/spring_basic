<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function chk(){
		location.href="cookieChk";
		window.close();
	}
</script>
<body>cookie_session_quiz/popup.jsp<hr>
	쿠키를 위한 팝업창 입니다.<br><br><br><br><br>
	<input type="checkbox" onclick="chk()">10초동안 띄우지않기
</body>
</html>