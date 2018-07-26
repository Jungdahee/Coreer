<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<script type="text/javascript">
	$(document).ready(function() {
		function idCheck() { // ID 중복체크 
			if ($("#id").val() == "")
				alert("아이디를 입력해주세요");
			else {
				
				$.ajax({
					url : "checkId.do",
					type : "post",
					data : {
						"checkId" : $("#id").val()
					},
					dataType : "json",
					success : function(data) {
						alert("1");
						alert(data.bol);

						if (data=="true") {
							alert("사용가능 아이디");
						}
						else
							alert("중복아이디");

					},
					fail : function(){
						alert("2");
					}
				});
			}
		}
			
		$("#btnCheckId").click(idCheck);
		
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
	<form action="join.do" method="post">
		<div>
			<label>ID</label><input type="text" id="id" name="id" value="${id}">
			<input type="button" id="btnCheckId" value="중복확인">
			
		</div>
		<div>
			<label>PW</label><input type="password" id="pw" name="pw">
		</div>
		<div>
			<label>PW 중복 확인</label><input type="password" id="pwCheck"
				name="pwCheck">
		</div>
		<div id="msg" style="color: red;"></div>
		<div>
			<label>이름</label><input type="text" id="name" name="name">
		</div>
		<div>
			<label>전화번호</label><input type="text" id="phone" name="phone" placeholder="-없이">
		</div>
		<div>
			<label>선호브랜드 1위</label>
			<select name="firstBrand">
				<option value="스타벅스">스타벅스</option>
				<option value="할리스">할리스</option>
				<option value="카페베네">카페베네</option>
				<option value="투썸플레이스">투썸플레이스</option>
				<option value="이디야">이디야</option>
				<option value="엔젤리너스">엔젤리너스</option>
				<option value="탐앤탐스">탐앤탐스</option>
				<option value="커피빈">커피빈</option>
			</select>
		</div>
		<div>
			<label>선호브랜드 2위</label>
			<select name="secondBrand">
				<option value="스타벅스">스타벅스</option>
				<option value="할리스">할리스</option>
				<option value="카페베네">카페베네</option>
				<option value="투썸플레이스">투썸플레이스</option>
				<option value="이디야">이디야</option>
				<option value="엔젤리너스">엔젤리너스</option>
				<option value="탐앤탐스">탐앤탐스</option>
				<option value="커피빈">커피빈</option>
			</select>
		</div>
		<div>
			<label>선호브랜드 3위</label>
			<select name="thirdBrand">
				<option value="스타벅스">스타벅스</option>
				<option value="할리스">할리스</option>
				<option value="카페베네">카페베네</option>
				<option value="투썸플레이스">투썸플레이스</option>
				<option value="이디야">이디야</option>
				<option value="엔젤리너스">엔젤리너스</option>
				<option value="탐앤탐스">탐앤탐스</option>
				<option value="커피빈">커피빈</option>
			</select>
		</div>
		<div>
			<input type="submit" value="확인">
		</div>
	</form>
	<div>
		<a href="login.jsp">이전</a>
	</div>
</body>
</html>

<!--회원 가입 페이지 -->