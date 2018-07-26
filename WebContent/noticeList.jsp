<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>공지사항 목록</title>
</head>
<%@ include file="header.jsp"%>
<body>

	<div>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${list}" var="vo">
					<tr>
						<td>${vo.notice_Number}</td>
						<td><a
							href="noticeContents.do?Notice_Number=${vo.notice_Number}">${vo.notice_Title}</a></td>
						<td>${vo.notice_Date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<div align="Center">
			<!-- 페이지 번호가 나오는 부분 -->
			<c:choose>
				<c:when test="${startPage!=null}">
					<a class="now" href='noticeList.do?page=1'>처음</a>
				<c:choose>
				
					<c:when test="${spage != 1}">
						<a href='noticeList.do?page=${spage-1}'>이전</a>
					</c:when>
				</c:choose>

				<c:forEach var="pageNum" begin="${startPage}" end="${endPage}">
					<c:if test="${pageNum == spage }">
					${pageNum}
					</c:if>
					<c:choose>
						<c:when test="${pageNum != spage }">
							<a href='noticeList.do?page=${pageNum}'>${pageNum}</a>
						</c:when>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${spage != maxPage }">
						<a href='noticeList.do?page=${spage+1}'>다음</a>
					</c:when>
				</c:choose>
				<a class="now" href='noticeList.do?page=${maxPage}'>끝</a>
										
				</c:when>
			</c:choose>
		</div>

		<br />
		
		<%if((int)session.getAttribute("sessionIsAdmin")==1){ %>
		
		<div>
			<a href="noticeInsert.jsp">공지사항 작성</a>
		</div>
		<%} %>
	</div>



</body>
</html>

<!-- 공지사항 페이지  -->