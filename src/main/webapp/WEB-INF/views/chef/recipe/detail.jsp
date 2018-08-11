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
				<c:if test="${memberf.photo !=''}">
					<img alt="" src="${ctx}${memberf.photo}">
				</c:if>
				<c:if test="${memberf.photo ==''}">
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
		
		
		
		<c:set var="test" value="0" />
										
										<c:forEach var="recipeLike" items="${recipeLike}">
											<c:if test="${recipeLike.recipeId == recipe.id}">
												<c:set var="test" value="1" />
											</c:if>
										</c:forEach >
										
										
											<c:if test="${test==1}">
												<img class="like-button detail" name="${recipe.id}" src="${ctx}/resources/images/like.png" style="cursor: pointer;">
											</c:if>
											<c:if test="${test==0}">
												<img class="like-button detail" name="${recipe.id}" src="${ctx}/resources/images/unlike.png" style="cursor: pointer;">
											</c:if>	
		
		
		<span>즐겨찾기 </span>
		</div>
		
			<img class="quote" src="${ctx}/resources/images/quote-l.png" style="margin-right: 20px">  
			<p class="detail-title">${recipe.title}</p>
			<img class="quote" src="${ctx}/resources/images/quote-r.png" style="margin-left: 20px">
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
		
		
		
		
		<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ -->
		
		<div class="reply-window">
			<h1 class="hidden">댓글 창</h1>
			<p style="color: #5fcad4">댓글   <span style="color: #066871">${commentCount}</span></p>
						<div class="cut">
							<c:forEach var="c" items="${recipe.comments }">
								<c:if test="${not empty c}">
									<c:if test="${empty c.profile}">
										<div><img alt="" src="${ctx}/resources/images/chef.png"></div>
									</c:if>
									<c:if test="${not empty c.profile}">
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
<script type="text/javascript">
  $(".like-button-section").click(function(){
    var recipeId = $(".like-button").attr('name');
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
        	$(".likeCount").text(parseInt($(".likeCount").text())-1);
        	//console.log(parseInt($(".likeCount").text())-1);  
      		//$(".likeCount").text('${likeCount-1}개');
      		
      	}
      	else{
        	$("img[name="+recipeId+"]").attr("src","${ctx}/resources/images/like.png")
      		alert("즐겨찾기에서 추가 하셨습니다");
        	$(".likeCount").text(parseInt($(".likeCount").text())+1);
        	//console.log(parseInt($(".likeCount").text())+1);  
      		//$(".likeCount").text('${likeCount+1}개');
        }   
      },
      error: function(request, status, error){ // 통신 실패시 - 로그인 페이지 리다이렉트
        alert("통신실패")
      },
    });   
  })
</script>
<script>
   
   $(function(){
      var submitButton  = $(".comment-form input[type='submit']");
      var commentView  = $(".reply-window .cut");
      
      submitButton.click(function(e){
         e.preventDefault();

         var data = $(".comment-form form").serialize();
         console.log(data);//data에는 내가 입력한 댓글의 내용이 들어간다
         
         
         
         
         $.post("${recipe.id}/comment/reg", data, function(result){ //result에는 결과값 1이 들어가 있따
        	 console.log(result);
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
	                  
	                  
	                  if(comments[i].profile != undefined)
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















  