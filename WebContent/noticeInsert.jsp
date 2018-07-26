<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>공지사항 입력</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div>
		<form action="noticeInsert.do" method="post">
			<div>
				<input type="text" placeholder="title" name="title">
			</div>
			<br/>
			<div>
				<textarea placeholder="contents" name="contents"></textarea>
			</div>
			<br/>
			<div>
				<input type="submit" value="작성">
			</div>
		</form>
		<a href="noticeList.do">목록으로</a>
	</div>
</body>
</html>