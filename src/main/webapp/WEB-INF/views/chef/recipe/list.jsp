<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
		
		<nav class="select-recipe-option2">
			<h1 class="hidden">레시피 분류</h1>
			<img class="menu-down-button" src="${ctx}/resources/images/caret-down.png">
		</nav>
		
		<nav class="select-recipe-view">
			<ul>
				<li>Date</li>
				<li>Popularity</li>
				<li>Random</li>
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
	
	menuDownButton.onclick = function(){
		if(selectRecipeOption2.classList.contains("show")==false){
			selectRecipeOption2.classList.add("show");
			menuDownButton.src = "${ctx}/resources/images/caret-arrow-up.png";
		}
		else{
			selectRecipeOption2.classList.remove("show");
			menuDownButton.src = "${ctx}/resources/images/caret-down.png";
		}
	};


	});
</script>