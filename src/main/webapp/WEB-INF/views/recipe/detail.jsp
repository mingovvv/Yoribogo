<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<main class="main">
	<div class="detail-container">
		<div class="when"><fmt:formatDate value="${recipe.regDate}" pattern="yyyy-MM-dd"/></div>
		<div class="representative-img">
			<img alt="" src="${ctx}${recipe.representativeImage}">
			<div class="profile">
				<c:if test="${memberf.photo !=null}">
					<img alt="" src="${ctx}${memberf.photo}">
				</c:if>
				<c:if test="${memberf.photo ==null}">
					<img alt="" src="${ctx}/resources/images/chef.png">
				</c:if>
				<span>${recipe.memberId}</span> 
			</div>
		</div>
		
		<div class="detail-main">
			<ul class="semi-box">
				<li><img alt="" src="${ctx}/resources/images/eye.png" style="border: 3px solid black"><span>조회수 <b style="color:black ">${recipe.readCount}회</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/chat.png" style="border: 3px solid #6b6bd9"><span>댓글 <b style="color:#6b6bd9 ">${commentCount}개</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/kitchen.png" style="border: 3px solid #dbc77e"><span style="color:#938658 ">즐겨찾기 <b class="likeCount" style="color:#938658 ">${likeCount}</b>개</span></li>
			</ul>
			<ul class="semi-box two">
				<li><img alt="" src="${ctx}/resources/images/cooktime.png" style="border: 3px solid gray"><span>조리시간 ${recipe.sortTime}</span></li>
				<li><img alt="" src="${ctx}/resources/images/bab.png" style="border: 3px solid #feab99"><span>${recipe.sortNational}</span></li>
				<li><img alt="" src="${ctx}/resources/images/tray2.png" style="border: 3px solid #3bb244"><span>${recipe.sortSituation}</span></li>
			</ul>
		
		

		
		<div class="like-button-section">
			<img class="like-button detail" name="${recipe.id}" src="${ctx}/resources/images/unlike.png" style="cursor: pointer;">
			<span>즐겨찾기 </span>
		</div>
		
			
			<p class="detail-title">
				<img class="quote" src="${ctx}/resources/images/quote-l.png" style="margin-right: 20px">  
					${recipe.title}
				<img class="quote" src="${ctx}/resources/images/quote-r.png" style="margin-left: 20px">
			</p>
			
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
				<c:if test="${foodOrder.image=='null'}">
				</c:if>
				<c:if test="${foodOrder.image!='null'}">
				<img src="${ctx}${foodOrder.image}">
				</c:if>
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
									<c:if test="${c.profile=='null'}">
										<div><img alt="" src="${ctx}/resources/images/chef.png"></div>
									</c:if>
									<c:if test="${c.profile!='null'}">
										<div><img alt="" src="${ctx}${c.profile}"></div>
									</c:if>
										<span class="aa">${c.memberId}</span>  <span class="bb"><fmt:formatDate value="${c.regDate}" pattern="yyyy-MM-dd KK:mm:ss"/></span> 
										<p>${c.content} </p>
								</c:if>
							</c:forEach>
							<c:if test="${empty recipe.comments}">
								<span style="font-size: 15px; text-align: center; color: #928686; margin-bottom: 20px; display: block;">소중한 첫번째 댓글의 기회를 잡으세요 :)</span>
							</c:if>
						</div>
		</div>			
				
				<template id="comment-template">
					<div>
						<div><img alt="" src=""></div>
						<span></span><span></span>
						<p></p>
					</div>
				</template>
			
		
		
		
		
		<section class="comment-form" id="comment-form">
         	<p style="text-align: center; color: gray;">로그인을 하시면 댓글서비스를<br> 이용할 수 있습니다.</p>
       		  <a href="${ctx}/chef/recipe/${recipe.id}"><p style="text-align: center; color: black; font-weight: bold;">로그인 하러 가기</p></a>
      </section>
		
		
		
		
		
		
		
	</div>
</main> 


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(".like-button-section").click(function(){
		var message = confirm("로그인 후 이용가능한 서비스입니다. 로그인 하시겠습니까?");
		
		var recipeId = $(".like-button").attr('name');
		
		if(message){
			location.replace("${ctx}/chef/recipe/"+recipeId);
		}
	})

</script>















  