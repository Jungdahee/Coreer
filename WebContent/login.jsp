<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<form action="login.do" method="post">
		<div>
			<label>ID : </label><input type="text" id="id" name="id">
		</div>
		<div>
			<label>PW : </label><input type="password" id="pw" name="pw">
		</div>
		<div>
			<input type="submit" value="로그인">
		</div>
	</form>
	
	<form action="memberFindUserInfo.jsp">
		<input type="submit" value="아이디/비밀번호 찾기">
	</form>
	
	<a href="memberJoin.jsp">회원가입</a>
</body>
</html>