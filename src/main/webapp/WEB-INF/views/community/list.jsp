<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">   
<!-- style 변경 버튼 -->    
<div class="community-view-style-btn">
	<form action="..." method="GET">
		<input type="button" class="btn" value="change-style" />
	</form>
</div>    
<!-- 게시글 디폴트 형식 --> 
<ul>
  <c:forEach var="list" items="${communityList}" >
	<li>
		<section id="community-section" class="${list.id}">
			<div class="community-main">  
				<div class="member-info">  
					<div class="member-img">
						<!-- 포이치에서 각각의 memberId에 해당하는 photo를 가져오는 방법 -->
			
							     
							<c:if test="${list.memberPhoto != null}">
								<img alt="" src="${ctx}${list.memberPhoto}" style="width:45px; height:45px; border-radius:100px;">
							</c:if>
							<c:if test="${list.memberPhoto == null}">
								<img alt="" src="${ctx}/resources/images/chef.png" style="width:45px; height:45px; border-radius:100px;">
							</c:if>
						        
					</div>
				</div>        
				<div class="content-main">
					<div class="reg-date">
						<div class="member-id">${list.memberId}</div>
						<div>${list.regDate}</div>      
					</div>
					<div class="content">
						<div class="content-img">여기에 이미지 태그만 파싱하여 가져오기(이미지 없는경우 텍스트만 노출)</div>
						<div class="content-text">(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)</div>
					</div>
				</div>
			</div>
      
			<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ --> 
			<section class="comment-section" id="${list.id}">  
			<div class="reply-window">
				<h1 class="hidden">댓글 창</h1>
				<p style="color: #5fcad4">
					댓글 <span style="color: #5fcad4"></span>
				</p>
				<div class="cut">
				<!-- -------------Comment-List--------------- -->
					<c:forEach var="c" items="">
						<c:if test="">
							<c:if test="">
								<div>
									<img alt="" src="${ctx}/resources/images/chef.png">
								</div>
							</c:if>
							<c:if test="">
								<div>
									<img alt="" src="">
								</div>
							</c:if>
							<span class="aa"></span>
							<span class="bb"></span>
							<p></p>
						</c:if>
					</c:forEach>
					
					<c:if test="">
						<span
							style="font-size: 15px; text-align: center; color: #928686; margin-bottom: 20px; display: block;">소중한
							첫번째 댓글의 기회를 잡으세요 :)</span>
					</c:if>
				</div>
			</div>
     		<template id="comment-template">
			<div>
				<img src="">
			</div>
			<span class="aa"></span> <span class="bb"></span>
			<p></p>
			</template>
			<section class="comment-form" id="comment-form">
		<!-- ----------------comment reg---------------------- -->
			<form action="${ctx}/chef/community/list/${list.id}/comment/reg" method="post">
				<div>    
					<label class="hidden">댓글</label>
					<textarea cols="48" rows="5" name="content"
						placeholder="댓글을 남겨주세요 :)"></textarea>
				</div>
				<div>
					<input type="submit" value="등록" class="btn" />
				</div>
			</form>
			</section> 
			</section> 
   
			<div class="community-more">
				<input class="more-icon ${list.id}" type="button" value="${list.id}"></input>
				<div class="comment">    
					<div>icon</div>    
					<span>cnt</span>
				</div>
			</div>
			</section>
		</li>	  
	</c:forEach>
</ul>    
<!-- 게시글 style 버튼에 디폴트(숫자로 페이지이동) -->
<div class="next"></div>
</main>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
 <script type="text/javascript">
	$(document).ready(function() {

						//0.text가 채워진 만큼만 community-main 확장할 수 있도록 한다.(o)
						$('#community-section').css('height', '400px');
       					//루프 돌려서 모든 게시물들(독립)을 해준다. 혹은 게시물 아이디 자식노드를 불러와서 부모를 숨긴다.
       					//$('.comment-section').hide();   
						
       					$('.reply-window').parent().hide();
						$('.more-icon').click(function(){             
										//클릭한 게시글의 id
										var listId = $(this).val();

											if ($(this).attr('id') == null) {
												$(this).attr('id',  
														'recover');  
												$("#"+listId).slideToggle();  
												$(this).parent().parent().css({  
													'min-height' : '400px',
													'height' : 'auto'
												});
												$(this).parent().parent().children().eq(0).attr(
														'class',
														'more-community-main');
												//content-main > (reg-date/content) > (content-img/content-text)
												$(this).parent().parent().children().eq(0).children().eq(1).attr(
														'class',
														'more-content-main');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(0).attr('class',
														'more-reg-date');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(1).attr('class',
														'more-content');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(1).children().eq(1).attr(
														'class',
														'more-content-text');  
      
												/*------------댓글 ajax로 리스트 가져오기-------------------  */
												//1.통신
												/*  $.ajax({
															type : 'POST',
															url : '/yoribogo/chef/community/list/commentList',
															data : {
																'listId' : listId
															},    
															dataType : 'json',  											
															success : function(data) {

																var results = data.commentList;
													            var str = '<TR>';
													             $.each(results , function(i){
													                str += '<TD>' + results[i]. + '</TD><TD>' + results[i].bdWriter + '</TD><TD>' + results[i].bdRgDt + '</TD>';
													                str += '</TR>';
													           });  
    
															},
															error : function(
																	request,
																	status,
																	error) {
																alert("code:"
																		+ request.status
																		+ "\n"
																		+ "message:"
																		+ request.responseText
																		+ "\n"
																		+ "error:"
																		+ error);
															}
														}); */  
     
											} else {    
												$(this).removeAttr('id');
												$("#"+listId).slideToggle();
												$(this).parent().parent().css({
													'min-height' : '0px',
													'height' : '396px'
												});
												$(this).parent().parent().children().eq(0).attr(
														'class',
														'community-main');
												$(this).parent().parent().children().eq(0).children().eq(1).attr(
														'class',
														'content-main');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(0).attr(
														'class', 'reg-date');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(1).attr(
														'class', 'content');
												$(this).parent().parent().children().eq(0).children().eq(1).children().eq(1).children().eq(1).attr(
														'class',
														'content-text');    
											}
  										   
								});    
						
					});    
</script>     
<script>
   
   $(function(){
      var submitButton  = $(".comment-form input[type='submit']");
      var commentView  = $(".reply-window .cut");
      
      submitButton.click(function(e){
         e.preventDefault();
		
         var data = $(".comment-form form").serialize();
         console.log(data);//data에는 내가 입력한 댓글의 내용이 들어간다
         $.post("${list.id}/comment/reg", data, function(result){ //result에는 결과값 1이 들어가 있따
        	 console.log(result);
               if(parseInt(result)==1){
            	   
            	   //&getjson 사용
            	   $.getJSON("${list.id}/ajax-comment-list", function(comments){
            		
            		   
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
