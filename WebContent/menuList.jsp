<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<%@ include file="header.jsp"%>
<body>
	<p>
	
	<%if(Integer.parseInt(session.getAttribute("sessionIsAdmin").toString())==1){ %>
		<a href="menuInsert.jsp">메뉴 추가</a>
	<%} %>
	
	<form action="menuList.do" method="post">
		<fieldset>
			<legend>커피</legend>
			<input type="checkbox" name="coffee" value="am" />아메리카노 
			<input type="checkbox" name="coffee" value="co" />콜드브루 
			<input type="checkbox" name="coffee" value="es" />에스프레소
			<input type="checkbox" name="coffee" value="ma" />마키아또 
			<input type="checkbox" name="coffee" value="fp" />플랫치노 
			<input type="checkbox" name="coffee" value="ch" />초콜릿 
			<input type="checkbox" name="coffee" value="la" />라떼 
			<input type="checkbox" name="coffee" value="mc" />모카 
			<input type="checkbox" name="coffee" value="cp" />카푸치노 
			<input type="checkbox" name="coffee" value="af" />아포가토
		</fieldset>
		<fieldset>
			<legend>브랜드</legend>
			<input type="checkbox" name="brand" value="1" />스타벅스
			<input type="checkbox" name="brand" value="2" />할리스
			<input type="checkbox" name="brand" value="3" />카페베네
			<input type="checkbox" name="brand" value="4" />투썸플레이스
			<input type="checkbox" name="brand" value="5" />이디야
			<input type="checkbox" name="brand" value="6" />엔젤리너스
			<input type="checkbox" name="brand" value="7" />탐앤탐스
			<input type="checkbox" name="brand" value="8" />커피빈
		</fieldset>

		<input type="submit" name="search" value="search" />
	</form>

	<table>
		<tbody>
			<c:forEach items="${list}" var="vo">
				<tr>
					<td><img src="${vo.menu_Image}" width=50, height=50></td>
					<td><a href="showMenuInfo.do?Menu_Number=${vo.menu_Number} ">${vo.menu_Name}</a></td>
					<td>${vo.menu_Price}원</td>
					<td>${vo.brand_Name}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>

<!-- 메뉴 목록 나오는 화면 -->