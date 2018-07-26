<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>공지사항 내용</title>
</head>
<%@ include file="header.jsp"%>
<body>
	<div>
		<div>제목</div>
		<div>${noticeContents.notice_Title}</div><br/>
		<div>내용</div>
		<div>${noticeContents.notice_Contents}</div><br/>
		<div>작성자</div>
		<div>${noticeContents.id}</div><br/>
		<div>날짜</div>
		<div>${noticeContents.notice_Date}</div>
	</div>
	<br/>
	<div>
		<a href="noticeList.do">이전</a>
		<%if((int)session.getAttribute("sessionIsAdmin")==1){ %>
		<a href="noticeLoad.do?Notice_Number=${noticeContents.notice_Number}">수정</a>
		<a href="noticeDelete.do?Notice_Number=${noticeContents.notice_Number}">삭제</a>
		<%} %>
	</div>
</body>
</html>