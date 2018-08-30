<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
		
		<form class="a">
			<div>
				<span>종류별</span>
				<br>
					<div>
					<input name="chkbox" id="checkAll" type="checkbox" value="all" />전체
					<input name="chkbox" class="chk" type="checkbox" value="한식" />한식
					<input name="chkbox" class="chk" type="checkbox" value="일식" />일식
					<input name="chkbox" class="chk" type="checkbox" value="중식" />중식
					<input name="chkbox" class="chk" type="checkbox" value="양식" />양식
					<input name="chkbox" class="chk" type="checkbox" value="기타" />기타
					</div>
				<br>
				<br>
				<span>상황별</span> 
				<br>
					<div>
					<input name="chkbox" id="checkAll2" type="checkbox" value="전체" />전체
					<input name="chkbox" class="chk2" type="checkbox" value="일상"/>일상
					<input name="chkbox" class="chk2" type="checkbox" value="다이어트"/>다이어트
					<input name="chkbox" class="chk2" type="checkbox" value="안주"/>안주
					<input name="chkbox" class="chk2" type="checkbox" value="건강"/>건강
					<input name="chkbox" class="chk2" type="checkbox" value="간식"/>간식
					<input name="chkbox" class="chk2" type="checkbox" value="야식"/>야식
					<input name="chkbox" class="chk2" type="checkbox" value="기타"/>기타
					</div>
				<br>
				<br>
				<span>시간별</span>
				<br>
					<div>
					<input name="chkbox" id="checkAll3" type="checkbox" value="전체"/>전체
					<input name="chkbox" class="chk3" type="checkbox" value="15분"/>15분
					<input name="chkbox" class="chk3"type="checkbox" value="30분"/>30분
					<input name="chkbox" class="chk3" type="checkbox" value="1시간"/>1시간
					<input name="chkbox" class="chk3" type="checkbox" value="2시간"/>2시간
					<input name="chkbox" class="chk3" type="checkbox" value="2시간 이상"/>2시간 이상
					</div>
			</div>
			
			<input class="chkSubmit" type="submit" value="검색"/>
			
			<nav class="select-recipe-option2">
				<h1 class="hidden">레시피 분류</h1>
				<img class="menu-down-button" src="${ctx}/resources/images/caret-down.png">
			</nav>
		</form>
		
		<nav class="select-recipe-view">
			<ul>
				<li class="date-button">Date</li>
				<li class="pop-button">Popularity</li>
				<li class="ran-button">Random</li>
			</ul>
		</nav>
 		<section class="recipe-list">  
			<h1 class="hidden">레시피목록</h1>
			<ul>
			
				<c:forEach var="recipe" items="${recipe}">
				
					<li>
						<div class = "frame">
							<div>
								<a href="${recipe.id}">
									<img src="${ctx}${recipe.representativeImage}">
								</a>
							</div>
							<div>${recipe.title}</div>
							<div>
								<div>${recipe.memberId}</div>
								<div> 
								
								   
										<c:set var="test" value="0" />
										
										<c:forEach var="recipeLike" items="${recipeLike}">
											<c:if test="${recipeLike.recipeId == recipe.id}">
												<c:set var="test" value="1" />
											</c:if>
										</c:forEach >
										
										
											<c:if test="${test==1}">
												<img class="like-button" name="${recipe.id}" src="${ctx}/resources/images/like.png" style="cursor: pointer;">
											</c:if>
											<c:if test="${test==0}">
												<img class="like-button" name="${recipe.id}" src="${ctx}/resources/images/unlike.png" style="cursor: pointer;">
											</c:if>											
								</div>
							</div>
						</div>       
					</li>
					      
				</c:forEach> 
			  
			</ul>
			
			
			
			
 		<template id="comment-template">

			
				
					<li>
						<div class = "frame">
							<div>
								<a href="${recipeDate.id}">
									<img src="${ctx}${recipeDate.representativeImage}">
								</a>
							</div>
							<div>${recipeDate.title}</div>
							<div>
								<div>${recipeDate.memberId}</div>
								<div> 
									<img class="like-button" name="" src="" style="cursor: pointer;">
								</div>
							</div>
						</div>       
					</li>
					      

		</template>
		
		
		
		</section> 
		
		
	</main>
	
	
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
$(function(){
	
	
	$(document).on("click",".like-button",function(){
		 var recipeId = $(this).attr('name')
		    console.log(recipeId);
		    console.log("${ctx}/chef/recipe/"+recipeId+"/like");
		    $.ajax({ // .like-button 버튼을 클릭하면 <새로고침> 없이 ajax로 서버와 통신하겠다.
		      type: "POST", // 데이터를 전송하는 방법을 지정
		      url: "${ctx}/chef/recipe/"+recipeId+"/like",
		      data: {"recipeId": recipeId}, // 서버로 데이터 전송시 옵션
		      dataType: "json", // 서버측에서 전송한 데이터를 어떤 형식의 데이터로서 해석할 것인가를 지정, 없으면 알아서 판단
		      // 서버측에서 전송한 Response 데이터 형식 (json)
		      
		      
		      success: function(data){ // 통신 성공시 - 동적으로 좋아요 갯수 변경, 유저 목록 변경
		        var selector = $("img[name="+recipeId+"]");
		        console.log(data);
		        
		      	if(selector.attr('src')=='/yoribogo/resources/images/like.png'){
		        	$("img[name="+recipeId+"]").attr("src","${ctx}/resources/images/unlike.png")
		        	alert("즐겨찾기에 삭제 하셨습니다");
		        console.log(selector.attr('src'));} 
		      	else//(selector.attr('src')=='/yoribogo/resources/images/unlike.png')
		        	{$("img[name="+recipeId+"]").attr("src","${ctx}/resources/images/like.png")   
		      		alert("즐겨찾기에서 추가 하셨습니다");
		        console.log(selector.attr('src'));}   
		       //$("#count-"+pk).html(response.like_count+"개");
		        //var users = $("#like-user-"+pk).text();
		        //if(users.indexOf(response.nickname) != -1){
		        //  $("#like-user-"+pk).text(users.replace(response.nickname, ""));
		        //}else{
		        //  $("#like-user-"+pk).text(response.nickname+users);
		        //}      
		      },
		      error: function(request, status, error){ // 통신 실패시 - 로그인 페이지 리다이렉트
		        alert("통신실패")
		      },
		    });   
	});
	
    
   
  	$(".date-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/chef/recipe/list/date',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				 
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			  console.log(result[i][1]);
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/chef/recipe/"+result[i][0].id;
					 image.src="${ctx}"+result[i][0].representativeImage;
					 title.textContent=result[i][0].title;
					 memberId.textContent=result[i][0].memberId;
					 
					 if(result[i][1]==0){
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i][0].id;
					 }else{
						 like.src= "${ctx}/resources/images/like.png";
						 like.name= result[i][0].id;
					 }
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				 
		})
	})
	
  	$(".pop-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/chef/recipe/list/pop',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				 
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			  console.log(result[i][1]);
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/chef/recipe/"+result[i][0].id;
					 image.src="${ctx}"+result[i][0].representativeImage;
					 title.textContent=result[i][0].title;
					 memberId.textContent=result[i][0].memberId;
					 
					 if(result[i][1]==0){
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i][0].id;
					 }else{
						 like.src= "${ctx}/resources/images/like.png";
						 like.name= result[i][0].id;
					 }
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				 
		})
	})
	
  	$(".ran-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/chef/recipe/list/ran',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				 
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			  console.log(result[i][1]);
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/chef/recipe/"+result[i][0].id;
					 image.src="${ctx}"+result[i][0].representativeImage;
					 title.textContent=result[i][0].title;
					 memberId.textContent=result[i][0].memberId;
					 
					 if(result[i][1]==0){
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i][0].id;
					 }else{
						 like.src= "${ctx}/resources/images/like.png";
						 like.name= result[i][0].id;
					 }
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				 
		})
	})
	
	
	//체크박스 전체 선택 및 전체 해제
	$("#checkAll").click(function(){
		if($("#checkAll").is(":checked")){
			$(".chk").prop("checked",true);
		}else{
			$(".chk").prop("checked",false);
		}
	});
	$("#checkAll2").click(function(){
		if($("#checkAll2").is(":checked")){
			$(".chk2").prop("checked",true);
		}else{
			$(".chk2").prop("checked",false);
		}
	});
	$("#checkAll3").click(function(){
		if($("#checkAll3").is(":checked")){
			$(".chk3").prop("checked",true);
		}else{
			$(".chk3").prop("checked",false);
		}
	});
	
	$(".chkSubmit").click(function(e){
		e.preventDefault();
		
		var data = $(".a").serialize();
			  console.log(data);
		
	});
  	
	
});
</script>






<script>
window.addEventListener("load", function(){
	var likeButton = document.querySelectorAll(".like-button");
	var menuDownButton = document.querySelector(".menu-down-button");
	var selectRecipeOption2 = document.querySelector(".select-recipe-option2");
	var a = document.querySelector(".a");
	var selectRecipeViewButton = document.querySelectorAll(".select-recipe-view ul li");
	var dateButton = document.querySelector(".date-button");
	var popButton = document.querySelector(".pop-button");
	var ranButton = document.querySelector(".ran-button");
	
	
	dateButton.onclick = function(){
		dateButton.style.background="#5fcad4";
		popButton.style.background="#95a5a3";
		ranButton.style.background="#95a5a3";
	}
	popButton.onclick = function(){
		dateButton.style.background="#95a5a3";
		popButton.style.background="#5fcad4";
		ranButton.style.background="#95a5a3";
	}
	ranButton.onclick = function(){
		dateButton.style.background="#95a5a3";
		popButton.style.background="#95a5a3";
		ranButton.style.background="#5fcad4";
	}
	
	

	 menuDownButton.onclick = function(){
		if(a.classList.contains("show")==false){
			a.classList.add("show");
			menuDownButton.src = "${ctx}/resources/images/caret-arrow-up.png";
		}
		else{
			a.classList.remove("show");
			menuDownButton.src = "${ctx}/resources/images/caret-down.png";
		}
	}; 


});
	
	

</script>