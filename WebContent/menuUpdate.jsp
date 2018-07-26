<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<%@ include file="header.jsp"%>
<body> 
	<form action="menuUpdate.do" method="post">
		<p>메뉴 이름 <input type="text" name="Menu_Name" value="${vo.menu_Name}"/>
		<p>메뉴 이미지<input type="file" name="Menu_Image" value="${vo.menu_Image}">
		<p>칼로리<input type="text" name="Menu_Calorie" value="${vo.menu_Calorie}"/>
		<p>카페인<input type="text" name="Menu_Caffeine" value="${vo.menu_Caffeine}"/>
		<p>용량<input type="text" name="Menu_Capacity" value="${vo.menu_Capacity}"/>
		<p>가격<input type="text" name="Menu_Price" value="${vo.menu_Price}"/>
		<input type="hidden" name="Menu_Number" value="${vo.menu_Number}"/>
		
		<input type = "submit" name = "update" value = "update" />
	</form>
	
</body>
</html>