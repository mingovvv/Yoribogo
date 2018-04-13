<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
		
		<nav class="select-recipe-option">
			<h1 class="hidden">레시피 분류</h1>
			<ul>
				<li>종류별</li>
				<li>전체</li>
				<li>한식</li>
				<li>중식</li>
				<li>일식</li>
				<li>양식</li>
				<li>기타</li>
			</ul>
			<ul>
				<li>상황별</li>
				<li>한식</li>
				<li>중식</li>
				<li>일식</li>
				<li>양식</li>
				<li>기타</li>
			</ul>
			<ul>
				<li>상황별</li>
				<li>한식</li>
				<li>중식</li>
				<li>일식</li>
				<li>양식</li>
				<li>기타</li>
			</ul>
			<ul>
				<li>조리시간</li>
				<li>15분이내</li>
				<li>30분이내</li>
				<li>1시간 이내</li>
				<li>2시간 이내</li>
				<li>2시간 이상</li>
			</ul>
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
	


	});
</script>