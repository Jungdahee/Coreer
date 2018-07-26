<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<%@ include file="header.jsp"%>
<script type="text/javascript">
	$(document).ready(function() {

		$("#pwCheck").keyup(function(){  // pw 확인
		      if($("#pw").val() != $("#pwCheck").val()){
		         $("#msg").text("동일한 PW가 아닙니다.");
		      }
		      else
		    	  $("#msg").text("동일한 PW입니다.");
		});
	});			
</script>
<body>
	<form action="modifyMyInfo.do" method="post">
		<div>
			<label>ID : ${myInfo.member_Id}</label>
		</div>
		<div>
			<label>Pw : </label><input type="password" id="pw" name="pw" value="${myInfo.member_Pw}">
		</div>
		<div>
			<label>Pw 확인 : </label><input type="password" id="pwCheck" name="pwCheck" value="${myInfo.member_Pw}">
		</div>
		<div id="msg" style="color: red;"></div>
		<div>
			<label>Name : </label> <input type="text" name= "name" value="${myInfo.member_Name}">
		</div>
		<div>
			<label>PhoneNumber : </label> <input type="text" name="phoneNumber" value="${myInfo.member_PhoneNumber}">
		</div>
		<div>
			<label>FirstBrand : </label> <input type="text" name="firstBrand" value="${myInfo.firstBrand}">
		</div>
		<div>
			<label>SecondBrand : </label> <input type="text" name="secondBrand" value="${myInfo.secondBrand}">
		</div>
		<div>
			<label>ThirdBrand : </label> <input type="text" name="thirdBrand" value="${myInfo.thirdBrand}">
		</div>
		
		<div align="center">
			<input type="submit" value="수정">
		</div>
	</form>
</body>
</html>

<!-- 내 정보 수정 페이지  -->