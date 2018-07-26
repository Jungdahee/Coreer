<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="findId.do" method="post">
		<label>이름</label>
		<input type="text"	name="name">
		<label>연락처</label>
		<input type="text" name="phoneNumber" placeholder="-없이">
		<input type="submit" value="아이디 찾기">
	</form>
	
	<form action="findPw.do" method="post">
		<label>아이디</label>
		<input type="text" name="id">
		<label>이름</label>
		<input type="text" name="name">
		<label>연락처</label>
		<input type="text" name="phoneNumber" placeholder="-없이">
		<input type="submit" value="비밀번호 찾기">
	</form>



</body>
</html>

<!-- 아이디/비밀번호 찾기  -->