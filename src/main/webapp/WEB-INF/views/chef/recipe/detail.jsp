<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<main class="main">
	<div class="detail-container">
		<div class="when">${recipe.regDate}</div>
		<div class="representative-img">
			<img alt="" src="${ctx}${recipe.representativeImage}">
			<div class="profile">
				<c:if test="${c.profile !=''}">
					<img alt="" src="${ctx}${memberf.photo}">
				</c:if>
				<c:if test="${c.profile ==''}">
					<img alt="" src="${ctx}/resources/images/cook-profile.png">
				</c:if>
				<span>${recipe.memberId}</span> 
			</div>
		</div>
		
		<div class="detail-main">
			<ul class="semi-box">
				<li><img alt="" src="${ctx}/resources/images/eye.png" style="border: 3px solid black"><span>조회수 <b style="color:black ">30회</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/chat.png" style="border: 3px solid #6b6bd9"><span>댓글 <b style="color:#6b6bd9 ">40개</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/kitchen.png" style="border: 3px solid #dbc77e"><span>즐겨찾기 <b style="color:#938658 ">30개</b></span></li>
			</ul>
			<ul class="semi-box two">
				<li><img alt="" src="${ctx}/resources/images/cooktime.png" style="border: 3px solid gray"><span>조리시간 ${recipe.sortTime}</span></li>
				<li><img alt="" src="${ctx}/resources/images/bab.png" style="border: 3px solid #feab99"><span>${recipe.sortNational}</span></li>
				<li><img alt="" src="${ctx}/resources/images/tray2.png" style="border: 3px solid #3bb244"><span>${recipe.sortSituation}</span></li>
			</ul>
			<p class="detail-title">${recipe.title}</p>
			<div class="content-wrapper"><p class="detail-content">${recipe.description}</p></div>
		</div>
		
		<div class="using-ingredient">
			<h1 class="hidden">사용된 재료</h1>
			<p style="color: #5fcad4;font-size: 24px;font-weight: bold; margin-left: 20px;">사용된 재료 <span style="color: #5fcad4"></span></p>
			<c:forEach var="ingredient" items="${ingredient}">
			<span>${ingredient.fname}</span>
			</c:forEach>
		</div>
		
		<div class="step-order">
			<h1 class="hidden">요리 순서</h1>
			<div style="color: #5fcad4;font-size: 24px;font-weight: bold; margin-left: 20px;">요리 순서 <span style="color: #5fcad4"></span></div>
			<c:forEach var="foodOrder" items="${foodOrder}">
			<span>Step ${foodOrder.chapter}</span>
			<div>
				<img src="${ctx}${foodOrder.image}">
			</div>
			<p>${foodOrder.content}</p>
			</c:forEach>
		</div>
		
		<div class="ggul-tip">
			<h1 class="hidden">꿀팁</h1>
			<div style="color: #5fcad4;font-size: 24px;font-weight: bold; margin-left: 20px; margin-bottom: 20px;">꿀팁 <span style="color: #5fcad4"></span></div>
			<div class="content-wrapper"><p class="detail-content">${recipe.ggulTip}</p></div>
		</div>
		
		<div class="reply-window">
			<h1 class="hidden">댓글 창</h1>
			<p style="color: #5fcad4">댓글 <span style="color: #5fcad4"></span></p>
						<div class="cut">
							<c:forEach var="c" items="${recipe.comments }">
								<c:if test="${not empty c}">
									<c:if test="${c.profile==''}">
										<div><img alt="" src="${ctx}/resources/images/chef.png"></div>
									</c:if>
									<c:if test="${c.profile!=''}">
										<div><img alt="" src="${ctx}${c.profile}"></div>
									</c:if>
										<span class="aa">${c.memberId}</span>  <span class="bb">${c.regDate}</span> 
										<p>${c.content} </p>
								</c:if>
							</c:forEach>
							<c:if test="${empty recipe.comments}">
								<span style="font-size: 15px; text-align: center; color: #928686; margin-bottom: 20px; display: block;">소중한 첫번째 댓글의 기회를 잡으세요 :)</span>
							</c:if>
						</div>
		</div>		
		
		<%-- <div class="reply-window">
			<h1 class="hidden">댓글 창</h1>
			<p style="color: #5fcad4">댓글 <span style="color: #5fcad4"></span></p>
				<c:forEach var="c" items="${recipe.comments }">
					<c:if test="${not empty c}">
						<div class="cut">
							<div><img alt="" src=""></div>
							<span class="aa">${c.memberId}</span>  <span class="bb">${c.regDate}</span> 
							<p>${c.content} </p>
						</div>
					</c:if>
				</c:forEach>
					<c:if test="${empty recipe.comments}">
						<p style="font-size: 15px; text-align: center; color: #928686;">소중한 첫번째 댓글의 기회를 잡으세요 :)</p>
					</c:if>
		</div> --%>		
				
				<template id="comment-template">
						<div><img src=""></div>
						<span class="aa"></span>  <span class="bb"></span> 
						<p></p>
				</template>
			
		
		
		
		<section class="comment-form" id="comment-form">
         <form action="${recipe.id}/comment/reg/" method="post">
            <div>
               <label class="hidden">댓글</label>
               <textarea cols="48" rows="5" name="content" placeholder="댓글을 남겨주세요 :)"></textarea>
            </div>
            <div>
               <input type="submit" value="등록" class="btn" />
            </div>
         </form>
      </section>
		
		
		
		
		
		
		
	</div>
</main> 


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
   
   $(function(){
      var submitButton  = $(".comment-form input[type='submit']");
      var commentView  = $(".reply-window .cut");
      
      submitButton.click(function(e){
         e.preventDefault();
         
         var data = $(".comment-form form").serialize();
         
         
         
         
         
         $.post("${recipe.id}/comment/reg", data, function(result){
               if(parseInt(result)==1){
            	   
            	   //&getjson 사용
            	   $.getJSON("${recipe.id}/ajax-comment-list", function(comments){
            		
            		   
            		commentView.empty();
                  
                  //1) template 얻어오기
                  var template = document.querySelector('#comment-template');
                  
                  
                  
                  for(var i=0; i < comments.length; i++ ){
	                  var cloneLi = document.importNode(template.content, true);
	                  var spans = cloneLi.querySelectorAll("span");
	                  var p = cloneLi.querySelector("p");
	                  var img = cloneLi.querySelector("img")
	                  
	                  
                	  spans[0].textContent=comments[i].memberId;
	                  spans[1].textContent=comments[i].regDate;
	                  p.textContent = comments[i].content;
	                  
	                  if(comments[i].profile !="")
	                  	img.src="${ctx}"+comments[i].profile;
	                  else
	                	  img.src="${ctx}/resources/images/chef.png";
	                  commentView.get(0).appendChild(cloneLi);
                  } 
                   

            	   });
            	   
            	   
               }
         });
         
         
         
      });
   });

</script>















  