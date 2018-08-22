<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
<h1>Hello ${memberId}!!!!!</h1>
<!-- style 변경 버튼 -->    
<div class="community-view-style-btn">
	<form action="..." method="GET">
		<input type="button" class="btn" value="change-style" />
	</form>
</div>
<!-- 게시글 디폴트 형식 --> 
  
		<section id="community-section">
			<div class="community-main">
				<div class="member-info">
					<div class="member-img"></div>
				</div>
				<div class="content-main">
					<div class="reg-date">
						<div class="member-id"></div>
					</div>
					<div class="content">
						<div class="content-img"></div>
						<div class="content-text"></div>
					</div>
				</div>
			</div>

			<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ --> <section
				class="comment-section">
			<div class="reply-window">
				<h1 class="hidden">댓글 창</h1>
				<p style="color: #5fcad4">
					댓글 <span style="color: #5fcad4"></span>
				</p>
				<div class="cut">
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
			</template> <section class="comment-form" id="comment-form">
			<form action="/comment/reg/" method="post">
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
			
			
			
			<!-- <section class="comment-section" style="display: none;">      
				<div>Hello more!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!</div>               
				foreach로 댓글 모두 불러올 것.           
					<div class="comment-main">
						<div class="comment-profile"></div>
						<div class="comment-content">
							<div class="content-top">
								<div class="comment-id"></div>
								<div class="comment-regdate"></div>
							</div>
							<div class="content-bottom">
								<div class="comment-text"></div>
							</div>
						</div>
					</div>
				
					<div class="comment-reg">
						<div class="input-text"></div>
						<div class="reg-btn"></div>
					</div>
				</section> --> <!-- 하단 more버튼, 클릭 반복시 이모티콘 바뀐다. -->
			<div class="community-more">
				<input class="more-icon" type="button"></input>
				<div class="comment">
					<div>icon</div>
					<span>cnt</span>
				</div>
			</div>
			</section>


<!-- 게시글 style 버튼에 디폴트(숫자로 페이지이동) -->
<div class="next"></div>
</main>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
						//0.text가 채워진 만큼만 community-main 확장할 수 있도록 한다.(o)
						$('#community-section').css('height', '400px');
						$('.comment-section').hide();
						$('.more-icon').click(function(){
											$('.comment-section').toggle();
											if ($('.more-icon').attr('id') == null) {
												$('.more-icon').attr('id',
														'recover');
												$('#community-section').css({
													'min-height' : '400px',
													'height' : 'auto'
												});
												$('.community-main').attr(
														'class',
														'more-community-main');
												//content-main > (reg-date/content) > (content-img/content-text)
												$('.content-main').attr(
														'class',
														'more-content-main');
												$('.reg-date').attr('class',
														'more-reg-date');
												$('.content').attr('class',
														'more-content');
												$('.content-text').attr(
														'class',
														'more-content-text');
      
												/*------------댓글 ajax로 리스트 가져오기-------------------  */
												//1.통신
												 /*$.ajax({
															type : 'POST',
															url : '/yoribogo/views/chef/community/list/commentList',
															data : {
																'listId' : $(
																		'#id')
																		.val()
															},
															dataType : 'html',
															success : function(data) {

																alert("telecom!!");

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
														});*/

											} else {
												$('.more-icon').removeAttr('id');
												$('#community-section').css({
													'min-height' : '0px',
													'height' : '396px'
												});
												$('.more-community-main').attr(
														'class',
														'community-main');
												$('.more-content-main').attr(
														'class',
														'content-main');
												$('.more-reg-date').attr(
														'class', 'reg-date');
												$('.more-content').attr(
														'class', 'content');
												$('.more-content-text').attr(
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
         $.post("/comment/reg", data, function(result){ //result에는 결과값 1이 들어가 있따
        	 console.log(result);
               if(parseInt(result)==1){
            	   
            	   //&getjson 사용
            	   $.getJSON("/ajax-comment-list", function(comments){
            		
            		   
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
