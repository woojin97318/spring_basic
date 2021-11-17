<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	function getUsers() {
		$.ajax({
			url : "users",
			type : "get",
			dataType : "json",
			success : function(list) {
				//$("#users").text(list)
				console.log(list)
				
				let html = ""
				/* //일반적인 for문
				for(var i = 0; i < list.length; i++) {
					html += "<b>이름 : </b>" + list[i].name + "님<br>"
					html += "<b>나이 : </b>" + list[i].age + "살<hr>"
				}
				$("#users").html(html)
				*/
				$.each(list, function(index, item) {
					html += "<b>이름 : </b>" + item.name + "님<br>"
					html += "<b>나이 : </b>" + item.age + "살<hr>"
				})
				$("#users").append(html)
				}
		})
	}
	function userInfo() {
		var userId = $("#userId").val()
		$.ajax({
			//url : "user?id=" + userId,
			url : "user/" + userId, // 경로 : user/홍길동1
			type : "get",
			dataType : "json",
			success : function(dto) {
				let html = "<b>이름 : </b>" + dto.name + "님<br>"
				html += "<b>나이 : </b>" + dto.age + "살<hr>"
				$("#users").html(html)
			}
		})
	}
	function modify() {
		let name = $("#name").val()
		let age = $("#age").val()
		let form = {name:name, age:age}
		$.ajax({
			url : "modify",
			type : "put",
			dataType : "json",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function(dto) {
				let html = "<b>이름 : </b>" + dto.name + "님<br>"
				html += "<b>나이 : </b>" + dto.age + "살<hr>"
				$("#users").html(html)
			}
		})
	}
	function membership() {
		/*
		let uId = $("#uId").val()
		let uName = $("#uName").val()
		let uAge = $("#uAge").val()
		let uAddr = $("#uAddr").val()
 		let uPhone = $("#uPhone").val()
 		let form = {uId:uId, uName:uName, uAge:uAge, uAddr:uAddr, uPhone:uPhone,}
		*/
		let form = {}
		let arr = $("#fo").serializeArray()
		console.log(arr)
		for(var i = 0; i < arr.length; i++) {
			form[arr[i].name] = arr[i].value
		}
		
		$.ajax({
			url : "membership",
			type : "post",
			dataType : "json",
			data : JSON.stringify(form),
			contentType : "application/json; charset=utf-8",
			success : function() {
				alert("회원가입 성공")
			}
		})
	}
</script>
</head>
<body>
	<span id="users"></span><hr>
	<button type="button" onclick="getUsers()">사용자 목록 보기</button>
	<hr>
	
	<input type="text" id="userId">
	<button type="button" onclick="userInfo()">개인 정보 보기</button>
	<hr>
	
	<input type="text" id="name" placeholder="수정할 이름 입력"><br>
	<input type="text" id="age" placeholder="수정할 나이 입력"><br>
	<button type="button" onclick="modify()">개인 정보 수정</button>
	<hr>
	
	<h3>회원가입</h3>
	<form id="fo">
		<input type="text" id="uId" name="uId" placeholder="id"><br>
		<input type="text" id="uName" name="uName" placeholder="name"><br>
		<input type="text" id="uAge" name="uAge" placeholder="age"><br>
		<input type="text" id="uAddr" name="uAddr" placeholder="addr"><br>
		<input type="text" id="uPhone" name="uPhone" placeholder="phone"><br>
		<input type="button" onclick="membership()" value="회원가입"><br>
	</form>
</body>
</html>