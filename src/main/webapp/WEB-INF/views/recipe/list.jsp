<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			
			<input type="submit" value="검색"/>
			
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
								
								   
										
										
												<img class="like-button" name="${recipe.id}" src="${ctx}/resources/images/unlike.png" style="cursor: pointer;">
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
<script>
$(function(){
	
$(".date-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/recipe/list/date',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				  
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/recipe/"+result[i].id;
					 image.src="${ctx}"+result[i].representativeImage;
					 title.textContent=result[i].title;
					 memberId.textContent=result[i].memberId;
					 
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i].id;
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				  
		})
	})
	
  	$(".pop-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/recipe/list/pop',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				 
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/chef/recipe/"+result[i].id;
					 image.src="${ctx}"+result[i].representativeImage;
					 title.textContent=result[i].title;
					 memberId.textContent=result[i].memberId;
					 
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i].id;
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				 
		})
	})
	
  	$(".ran-button").click(function(e){
  		
		
		e.preventDefault();
		
		 $.getJSON('${ctx}/recipe/list/ran',function(result){
			 
				  
			 	console.log(result);
				$(".recipe-list ul").empty();
				 
				 
				 
					var template = document.querySelector('#comment-template');
				 
				    
		 		  for(var i =0; i < result.length;i++){
		 			  
		 			 
		 			   
		 			 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var like = clone.querySelector(".frame div:nth-child(3) div:nth-child(2) img");
					 
					 recipeId.href="${ctx}/chef/recipe/"+result[i].id;
					 image.src="${ctx}"+result[i].representativeImage;
					 title.textContent=result[i].title;
					 memberId.textContent=result[i].memberId;
					 
						 like.src= "${ctx}/resources/images/unlike.png";
						 like.name= result[i].id;
					    
					   
					 $(".recipe-list ul").get(0).appendChild(clone);
				 } 
				 
		})
	})
	
	
	
	
	$(document).on("click",".like-button",function(){
		if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?"))
			location.href="${ctx}/member/login";
	});
});

 


window.addEventListener("load", function(){
	var likeButton = document.querySelectorAll(".like-button");
	var menuDownButton = document.querySelector(".menu-down-button");
	var selectRecipeOption2 = document.querySelector(".select-recipe-option2");
	var a = document.querySelector(".a");
	var selectRecipeViewButton = document.querySelectorAll(".select-recipe-view ul li");
	var dateButton = document.querySelector(".date-button");
	var popButton = document.querySelector(".pop-button");
	var ranButton = document.querySelector(".ran-button");
	
	
    /* for(var i=0;i<likeButton.length;i++){
    	(function(m) {
    		likeButton[m].onclick = function(){
					if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?"))
    					location.href="${ctx}/member/login";
    		}
    	})(i);
	};  */
	
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