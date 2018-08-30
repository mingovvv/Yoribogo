<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<main class="main" style="margin:0px; " > 
 
<!--  <p>요리보고와 함께 즐거운 요리 어떠세요? </p> -->
 	<div>
		<section class="recipe-list">
			<h1 class="hidden">레시피목록</h1>
			<ul style="flex-wrap: nowrap; overflow: hidden; height: auto;">
			
				<c:forEach var="recipe" items="${recipe}">
				
						<li style="display: inline-block;">
						 
						
							<div class="frame" style="margin: 0;">
								<div>
									<a href="recipe/${recipe.id}">
									<img src="${ctx}${recipe.representativeImage}">
									</a>
								</div>
								<div style="overflow: -webkit-paged-y;">${recipe.title}</div>
								<div>
									<div style="font-size: 18px">${recipe.memberId}</div>
									<div style="color: #d07376; position: absolute; right: 0%; bottom:  0%;" >${recipe.sortTime}</div>
								</div>
							</div>
							
							   
						</li>
				
					</c:forEach>  
				
			</ul>


<!-- <template id="comment-template">

		<div class="frame">
		
			<div>
				<a href=""> <img src="">
				</a>
			</div>
		
			<div></div>
		
			<div>
				<div></div>
		
				<div></div>
		
			</div>
		
		</div>

</template> -->
</div>		
		     
			</section>
</main>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${ctx}/resources/js/jquery.liMarquee.js"></script>
<script>    
$(function() { 
	$('.recipe-list ul').liMarquee({
		direction: 'left',	
		loop:-1,			
		scrolldelay:0,		
		scrollamount:100,	
		circular: true,		
		drag: true			
	});
});
/*  	(function() {
	 var j=1;
		setInterval(function() {

			$.getJSON('${ctx}/index/circle', function(result) {
				console.log(result);
				console.log(result.length); 
				 $(".recipe-list ul li").empty();

				 var template = document.querySelector('#comment-template');
				 
				 
				
				 for(var i=j; i<j+2 ; i++){
					 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var readCount = clone.querySelector(".frame div:nth-child(3) div:nth-child(2)");
					 
					 recipeId.href="${ctx}/recipe/"+result[i].id;
					 image.src="${ctx}"+result[i].representativeImage;
					 title.textContent=result[i].title;
					 readCount.style.color="#d07376";
					 readCount.style.position="absolute";
					 readCount.style.right="0%";
					 readCount.style.bottom="0%";
					 readCount.textContent=result[i].sortTime;
					    
					 
					 $(".recipe-list ul li").get(0).appendChild(clone);
				 }
				 j++;
				 
				 if(result.length == j+1)
					 j=0;
				  
			});

		}, 3000);
	}); */

	window.addEventListener("load", function() {
		/* var likeButton = document.querySelector("#like-button"); */
		/* var likeButton = document.getElementById("like-button"); */
		/* var likeButton = document.getElementsByClassName("like-button"); */
		var likeButton = document.querySelectorAll(".like-button");

		for (var i = 0; i < likeButton.length; i++) {
			(function(m) {
				likeButton[m].onclick = function() {
					if (confirm("로그인이 필요한 서비스입니다. 로그인 하시겠습니까?"))
						location.href = "${ctx}/member/login";
				}
			})(i);
		}

	});
</script>