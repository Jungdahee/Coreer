<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div align="left">
		<a href="menuList.do">메뉴</a>
		<a href="noticeList.do">공지사항</a>
	</div>
	<div align="right">
		${sessionName}님 환영합니다.
		<a href="showMyInfo.do?Id=${sessionId}">내정보 보기 </a>
		<a href="logout.do">로그아웃</a>
	</div>
</body>
</html>