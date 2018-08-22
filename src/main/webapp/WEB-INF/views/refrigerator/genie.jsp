<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<main class="main">
	<section class="container genie">
		
		
		
		
		
		
	<div class="half bg genie">
		<img style="border-radius: 20px;" src="${ctx}/resources/images/genie.gif">
	</div>
	
	
	
	
	
	
	
	
	<article class="half genie">
		<h1>냉장고를 부탁해 지니!</h1>
		<span>냉장고 안에 있는 재료를 입력해주시면 <br />가지고 계신 재료를 사용한 <br />요리보고 레시피를 추천해드립니다 :)</span>
		
		<div class="content genie">
			<div class="signin-cont cont">
				<form method="post">
					<input type="text" name=list[] class="inpt" required="required" placeholder="재료를 입력해주세요"> 
					<img id="ingrdeient_del_1" class="btn-cancel" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
					
					<div class="submit-wrap">
						<input type="button" value="재료 추가" class="ingbutton">
						<input type="submit" value="레시피 검색" class="ingsubmit"> 
					</div>
				</form>
			</div>
			 
		</div>  
	</article>




	<div class="showView">
	
	
	</div>

  

	<template id="comment-template">


					
			 
			
									<div class="frame">
									
										<div>
											<a href="${recipe.id}"> <img
												src="${ctx}${recipe.representativeImage}">
											</a>
										</div>
										
										<div>${recipe.title}</div>
										
										<div>
											<div>${recipe.memberId}</div>
											
											<div>
												<%-- <a href="#"><img class="like-button"
													src="${ctx}/resources/images/unlike.png"></a> --%>
											</div>
											
										</div>
										
									</div>
			
			
								


		</template>
		
		
		
		
    
</section>
	
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	var i=1;
	$(".ingbutton").click(function(){ 
		i++;
		$("	<input type=\"text\" name=\"list[]\" class=\"inpt\" required=\"required\" placeholder=\"재료를 입력해주세요\"><img id=\"ingrdeient_del_1\" class=\"btn-cancel\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\"> 	").insertBefore($(".submit-wrap"));
	
		
	});
	
	$(document).on("click",".btn-cancel",function(){ //함수 바인딩
		
		
		$(this).prev().remove();
		$(this).remove();
		
		
	})
	
	$(".ingsubmit").click(function(e){
		 $(".container").find($(".de")).remove(); 
		var view = $(".showView");
		
		e.preventDefault();
		var data = $(".content.genie form").serialize();
		console.log(data);
		
		 $.getJSON('${ctx}/refrigerator/genie/search',data,function(result){
			 console.log(result);
			 
			 if(result.length==0){
				 $(".container").find($(".de")).remove(); 
				 $(".showView").empty();
				 
				 var noResult=$("	<span >아쉽게도 입력해주신 재료로 만들 수 있는 요리레시피가 없습니다 ㅠㅠ<br /></span>	");
				 var goRecipe=$("	<span >직접 요리 해보시는 건 어떨까요? <br /><a href=\"${ctx}/chef/recipe/reg\">레시피 등록하기</a></span>	");
				 noResult.appendTo(view);
				 goRecipe.appendTo(view);
				 
			 }else{
				  
				 $(".showView").empty();
				 $(".container").find($(".de")).remove(); 
				 
				 var template = document.querySelector('#comment-template');
				 
				 var yesRecipe=$("	<p class=\"de\" >해당 재료로 만들수 있는 레시피입니다 :) </p>	");
				 yesRecipe.css("margin-bottom","50px").css("color","#32bea6").css("font-size","20px").css("padding","5%").css("font-weight","700");
				 yesRecipe.insertBefore(view); 
		 
				 for(var i =0; i < result.length;i++){
					 console.log(template.content);
					 var clone = document.importNode(template.content,true);
					 
					 var recipeId = clone.querySelector(".frame > div > a");
					 var image = clone.querySelector(".frame > div > a > img");
					 var title = clone.querySelector(".frame div:nth-child(2)");
					 var memberId = clone.querySelector(".frame div:nth-child(3) div:nth-child(1)");
					 var readCount = clone.querySelector(".frame div:nth-child(3) div:nth-child(2)");
					 
					 recipeId.href="${ctx}/recipe/"+result[i].id;
					 image.src="${ctx}"+result[i].representativeImage;
					 title.textContent=result[i].title;
					 memberId.textContent=result[i].memberId+" 님";
					 readCount.style.color="#d07376";
					 readCount.style.position="absolute";
					 readCount.style.right="0%";
					 readCount.style.bottom="0%";
					 readCount.textContent=result[i].sortTime;
					    
					 
					 view.get(0).appendChild(clone);
				 } 
				 
			 }
				    
			 
		})
	})
	
	
});
</script>