<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		getReview();
	});
	
	
	// 좋아요 싫어요 컨트롤을 위해 history 테이블에서 데이터 가져오기
	function getHistory(reviewNum){
		var getHistoryResult;
		$.ajax({
			url : "./reviewHistory",
			type : "post",
			data : {
				reviewNum : reviewNum,
				userId : '<%=session.getAttribute("sessionId")%>'
			},
			success : function (data){
				getHistoryResult = data.substr(23, 1);
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});
		return getHistoryResult;
	}
	
	// 리뷰 리스트
	function getReview(){
		$.ajax({
			url : "./reviewList",
			type : "post",
			data : {
				Menu_Number : "${vo.menu_Number}"	
			},
			success : function (data){
				var object = eval('('+data+')');
				var resultData = object.result;
				var reviewListHTML = ""; 
				$.each(resultData, function(i, itemOne){
					reviewListHTML += "<div id='reviewList"+ i +"'>";
					reviewListHTML += "<hr>";
					$.each(itemOne, function(j, itemTwo){
						if(j==1){ // 메뉴 id 제외
							reviewListHTML += "<div style='display:none;'>"+ resultData[i][1].value +"</div>";
						}
						else if(j==2){ // 리뷰번호 제외
							reviewListHTML += "<div style='display:none;' id=reviewNum"+ i +" >"+ resultData[i][2].value +"</div>";
						}
						else if(j==6 && (getHistory(resultData[i][2].value) == null)){
							reviewListHTML += "<div>"+ resultData[i][j].value +"<button id='likeBtnId"+ i +"' class='likeBtn'>좋아요</button></div>";
						}
						else if(j==6 && (getHistory(resultData[i][2].value) == '2')){
							reviewListHTML += "<div>"+ resultData[i][j].value +"<button id='likeBtnId"+ i +"' class='likeBtn'>좋아요</button></div>";
						}
						else if(j==6 && (getHistory(resultData[i][2].value) == '1')){
							reviewListHTML += "<div>"+ resultData[i][j].value +"<button id='likeBtnId"+ i +"' class='likeBtn'>좋아요</button></div>";
						}
						else if(j==6 && (getHistory(resultData[i][2].value) == '0')){
							reviewListHTML += "<div>"+ resultData[i][j].value +"<button id='likeBtnId"+ i +"' class='likeBtn'>좋아요</button></div>";
						}
						
						else{
							reviewListHTML += "<div>"+ resultData[i][j].value +"</div>";
						}	
					})
					if(resultData[i][0].value == '<%=session.getAttribute("sessionId").toString()%>'){
						reviewListHTML += "<button type='button' class='modifyBtn' id='modifyBtn"+ i +"'>수정</button>";
						reviewListHTML += "<button type='button' class='deleteBtn' id='deleteBtn"+ i +"'>삭제</button>";
					}
					reviewListHTML += "<div id='modifyDiv"+ i +"' style='display:none;'><form id='reviewUpdateForm"+ i +"'>";
					reviewListHTML += "<input type='text' value='"+resultData[i][3].value +"' maxlength='300' placeholder='insert contents' name='reviewUpdateContents' id='reviewUpdateContents'>";
					reviewListHTML += "<input type='number' value='"+resultData[i][5].value+"'min='1' max='5' placeholder='score' name='reviewUpdateScore' id='reviewUpdateScore'>";
					reviewListHTML += "<input type='hidden' value='"+ resultData[i][2].value +"'  name='reviewUpdateReviewNumber' id='reviewUpdateReviewNumber'>";
					reviewListHTML += "<input value='수정' type='button' name='reviewUpdateBtn' id='reviewUpdateBtn"+ i +"'>";
					reviewListHTML += "</form></div>";
					reviewListHTML += "</div>";
					reviewListHTML += "<hr>";
				});
				$("#reviewList").html(reviewListHTML);
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});
	}
	
	
	// 좋아요 눌렀을 때
	$(document).on('click','.likeBtn',function(){
		//var getReviewNumber = "likeBtn" + $(this).attr('id').substr(9,1);
		//$("#"+getReviewNumber).toggle();
		var getReviewNumber = "reviewNum" + $(this).attr('id').substr(9,1);
		var reviewNumber = $("#"+getReviewNumber).html();
		$.ajax({
			url : "./clickGoodBadBtn",
			type : "post",
			data : {
				reviewNum : reviewNumber,
				goodOrBad : 'good',
				user_id   : '<%=session.getAttribute("sessionId").toString()%>'
			},
			success : function (data){
				getReview();
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		}); 
	});
	
	
	// 싫어요 눌렀을 때
	$(document).on('click','.hateBtn',function(){
		
		var getReviewNumber = "reviewNum" + $(this).attr('id').substr(9,1);
		var reviewNumber = $("#"+getReviewNumber).html();
		$.ajax({
			url : "./clickGoodBadBtn",
			type : "post",
			data : {
				reviewNum : reviewNumber,
				goodOrBad : 'bad',
				user_id   : '<%=session.getAttribute("sessionId").toString()%>'
			},
			success : function (data){
				getReview();
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});
	});
	
	
	// 리뷰 등록
	$(document).on('click','#insertBtn',function(){
		var params = $('#reviewInsert').serialize();
		$.ajax({
			url : "./insertReview",
			type : "post",
			data : params,
			success : function (data){
				getReview();
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});
	});
	
	
	// 수정 폼 활성화
	$(document).on('click','.modifyBtn',function(){
		var reviewListId = "modifyDiv" + $(this).attr('id').substr(9,1);
		$("#"+reviewListId).toggle();
	}); 
	
	
	// 리뷰 업데이트
	$(document).on('click','input[name=reviewUpdateBtn]',function(){
		var reviewUpdateForm = "reviewUpdateForm" + $(this).attr('id').substr(15,1);
		var params = $('#'+reviewUpdateForm).serialize();
		$.ajax({
			url : "./updateReview",
			type : "post",
			data : params,
			success : function (data){
				getReview();
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});  
	});
	
	
	// 리뷰 삭제
	$(document).on('click','.deleteBtn',function(){
		var getReviewNumber = "reviewNum" + $(this).attr('id').substr(9,1);
		var reviewNumber = $("#"+getReviewNumber).html();
		
		$.ajax({
			url : "./deleteReview",
			type : "post",
			data : {
				reviewNumber : reviewNumber
			},
			success : function (data){
				getReview();
			},
			error:function(request,status,error){
				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        }
		});  
	});
	
</script>
</head>
<%@ include file="header.jsp"%>
<body>
<table>
     <tr>
   	  <td><img src="${vo.menu_Image}" width=100, height=100></td>
   	  <td>${vo.brand_Name}</td>
   	  <td>${vo.menu_Name}</td>
      <td>${vo.menu_Price}</td>
	  <td>${vo.menu_Caffeine}</td>
	  <td>${vo.menu_Calorie}</td>
	 </tr> 
</table>
   
   <div>
      <a href="menuList.do">전 페이지</a>
      <%if(Integer.parseInt(session.getAttribute("sessionIsAdmin").toString())==1){ %>
      <a href="menuLoad.do?Menu_Number=${vo.menu_Number}">메뉴 수정</a>
      <a href="menuDelete.do?Menu_Number=${vo.menu_Number}">메뉴 삭제</a>
      <%} %>
   </div>
  <!-- 댓글영역 -->

<div>
	<div>
		<form name='reviewInsert' id='reviewInsert' >
			<input type='text' maxlength='300' placeholder="insert contents" name='reviewContents'>
			<input type='number' min='1' max='5' placeholder="score" name="score">
			<input value="${vo.menu_Number}" name="menu_number" type="hidden">
			<input value="<%=session.getAttribute("sessionId")%>" name = "userId" type="hidden">
			<input value='등록' type="button" id='insertBtn' name='insertBtn'>
		</form>
	</div>
	<div id="reviewList"></div>
</div>
</body>
</html>

<!-- 메뉴 클릭 후 상세 정보 및 리뷰  -->