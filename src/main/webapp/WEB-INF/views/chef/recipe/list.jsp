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
					<input type="checkbox" value="#" checked="checked" />전체
					<input type="checkbox" value="#"/>한식
					<input type="checkbox" value="#"/>일식
					<input type="checkbox" value="#"/>중식
					<input type="checkbox" value="#"/>양식
					<input type="checkbox" value="#"/>기타
					</div>
				<br>
				<br>
				<span>상황별</span>
				<br>
					<div>
					<input type="checkbox" value="#" checked="checked"/>전체
					<input type="checkbox" value="#"/>일상
					<input type="checkbox" value="#"/>다이어트
					<input type="checkbox" value="#"/>안주
					<input type="checkbox" value="#"/>건강
					<input type="checkbox" value="#"/>간식
					<input type="checkbox" value="#"/>야식
					<input type="checkbox" value="#"/>기타
					</div>
				<br>
				<br>
				<span>시간별</span>
				<br>
					<div>
					<input type="checkbox" value="#" checked="checked"/>전체
					<input type="checkbox" value="#"/>15분
					<input type="checkbox" value="#"/>30분
					<input type="checkbox" value="#"/>1시간
					<input type="checkbox" value="#"/>2시간
					<input type="checkbox" value="#"/>2시간 이상
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
			
				<c:forEach begin="0" end="30">
				
					<li>
						<div class = "frame">
							<div><img src="${ctx}/resources/images/sample-images.png"></div>
							<div>모두가 좋아하는 등갈비 </div>
							<div>
								<div>by 자취왕</div>
								<div><a href="#"><img class="like-button" src="${ctx}/resources/images/unlike.png"></a></div>
							</div>
						</div>
					</li>
					
				</c:forEach>
				
			</ul>
		</section>
	</main>

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
	
	
    for(var i=0;i<likeButton.length;i++){
    	(function(m) {
    		likeButton[m].onclick = function(){
    			if(likeButton[m].src.match("unlike")){
					alert("레시피 저장고에 등록되었습니다 :)");   				
    				likeButton[m].src = "${ctx}/resources/images/like.png";
    			}
    			else{
    				likeButton[m].src = "${ctx}/resources/images/unlike.png";
    				alert("레시피 저장고에서 삭제 되었습니다 :)");  				
    			}
    		}
    	})(i);
	}; 
	
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