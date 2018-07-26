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
   <form action="menuInsert.do" method="post">
   	  <p>메뉴 번호<input type="text" name="Menu_Number" value="Menu_Number"/>
   	  <p>메뉴 이름<input type="text" name="Menu_Name" value="Menu_Name"/>
   	  <p>브랜드 번호<input type="text" name="Brand_Number" value="Brand_Number"/>
   	  <p>메뉴 이미지<input type="text" name="Menu_Image" value="Menu_Image"/>
   	  <p>가격<input type="text" name="Menu_Price" value="Menu_Price"/>
   	  <p>용량<input type="text" name="Menu_Capacity" value="Menu_Capacity"/>
   	  <p>칼로리<input type="text" name="Menu_Calorie" value="Menu_Calorie"/>
   	  <p>카페인<input type="text" name="Menu_Caffeine" value="Menu_Caffeine"/>
   	  <p>평점<input type="text" name="Menu_AvgScore" value="Menu_AvgScore"/>
   	  
   	<input type = "submit" name = "insert" value = "insert" />  
   </form>

</body>
</html>