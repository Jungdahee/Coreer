<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<%@ include file="header.jsp"%>
<body>
	<div>
		<label>ID : </label> ${myInfo.member_Id}
	</div>
	<div>
		<label>Name : </label> ${myInfo.member_Name}
	</div>
	<div>
		<label>PhoneNumber : </label> ${myInfo.member_PhoneNumber}
	</div>
	<div>
		<label>Point : </label> ${myInfo.member_Point}
	</div>
	<div>
		<label>FirstBrand : </label> ${myInfo.firstBrand}
	</div>
	<div>
		<label>SecondBrand : </label> ${myInfo.secondBrand}
	</div>
	<div>
		<label>ThirdBrand : </label> ${myInfo.thirdBrand}
	</div>
	<a href="memberPwCheck.jsp">수정</a>
	<%if((String)session.getAttribute("sessionId")==null || request.getAttribute("dropDate")==null){ %>
	<a href="dropMember.do">탈퇴</a>
	<%}else{%>
	<a href="dropCancelMember.do">탈퇴취소</a>
	<%} %>
	 
	<a href="noticeList.do">이전</a>
</body>
</html>

<!-- 내 정보 보기 페이지  -->