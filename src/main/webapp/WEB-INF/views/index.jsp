<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
		
		<div>
			<p class="line"></p>
		</div>

		<section class="recipe-list">
			<h1 class="hidden">레시피목록</h1>
			<ul>
			
		<!-- 	<p style="font-size: xx-large;">뭘루 채울까 고민중...</p> -->
				<c:forEach begin="0" end="3">
				
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
	/* var likeButton = document.querySelector("#like-button"); */
	/* var likeButton = document.getElementById("like-button"); */
	/* var likeButton = document.getElementsByClassName("like-button"); */
	var likeButton = document.querySelectorAll(".like-button");
	
	
    for(var i=0;i<likeButton.length;i++){
    	(function(m) {
    		likeButton[m].onclick = function(){
					if(confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?"))
    					location.href="${ctx}/member/login";
    		}
    	})(i);
	}; 
	


	});
</script>