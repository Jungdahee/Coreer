<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>공지사항 수정</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div>
		<form
			action="noticeUpdate.do?notice_Number=${noticeContents.notice_Number}"
			method="post">
			<div>
				<input type="text" placeholder="title" name="title" value="${noticeContents.notice_Title}">
			</div>
			<br/>
			<div>
				<textarea placeholder="contents" name="contents">${noticeContents.notice_Contents}</textarea>
			</div>
			<br/>
			<div>
				<input type="submit" value="수정">
			</div>
		</form>
		<div>
		<a href="noticeContents.do?Notice_Number=${noticeContents.notice_Number}">이전</a>
		<a href="noticeList.do">목록으로</a>
		</div>
	</div>
</body>
</html>