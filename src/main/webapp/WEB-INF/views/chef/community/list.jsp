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


<!-- 게시글 페이징 디폴트 --> 
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
					<!-- .content 포인팅 하고 -->
					<!-- ajax로 .content json으로 불러와서 데이터 뽑아낸다 -->
					<!-- 스마트 에디터의 첫번째 이미지 데이터와 첫번째 글의 200자만 on되었을때 ajax로 뿌려줄 것. -->
					<!-- 스크립트로 이미지가 없다면 <div class="content-text" style="~~~">+텍스트200자+</> -->
					<!-- 스크립트로 이미지가 존재하면 <div class="content-img"><img src=""></></>
											  <div class="content-text">+텍스트200자+</> 추가-->
					<!-- more 클릭 시 해당 게시글에 한해(listId) 추가적으로 배열에 담긴 데이터들을 담아올 것. -->
					<div class="content">
							<div class="content-img"><img src="">여기에 이미지 태그만 파싱하여 가져오기(이미지 없는경우 텍스트만 노출)</img></div>
							<div class="content-text">(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)(타이틀로 넣은 텍스트 혹은 content에서 불러온 텍스트 200자)</div>
					</div>
				</div>
			</div>
      
			<!-- ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ댓글ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ --> 
			<section class="comment-section" id="${list.id}">  
			<div class="reply-window">
				<p style="color: #5fcad4">
					댓글 <span style="color: #5fcad4"></span>
				</p>
				<div class="cut">
				<!-- -------------Comment-List--------------- -->	
						
				<!-- -------------Comment-List-end--------------- -->			
				</div>
			</div>  
			
     		<template id="comment-template">
				<div>
					<img src="">
				</div>
				<span class="aa"></span> <span class="bb"></span>
				<p></p>
			</template>
	<!-- ----------------comment reg---------------------- -->
			<section class="comment-form" id="comment-form">
			<form>  
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
												//댓글 submit 버튼
												var submitButton  = $(this).parent().parent().children().eq(1).children().eq(2).children().eq(0).children().eq(1).children().eq(0);
         										//입력한 댓글창
											    var commentView  = $(this).parent().parent().children().eq(1).children().eq(0).children().eq(1);
  
												/*------------댓글 ajax로 리스트 가져오기-------------------  */
											    //("<span style="font-size: 15px; text-align: center; color: #928686; margin-bottom: 20px; display: block;">소중한 첫번째 댓글의 기회를 잡으세요 :)</span>")
													$.getJSON(listId+"/ajax-comment-list", function(comments){
														console.log(comments.length);  
									            	if(comments.length == 0){    
									            		$(commentView).html("<span style=\"font-size: 15px; text-align: center; color: #928686; margin-bottom: 20px; display: block;\">소중한 첫번째 댓글의 기회를 잡으세요 :)</span>");
									            	}else{   
													  var template = document.querySelector('#comment-template');
													   
									                  for(var i=0; i < comments.length; i++ ){
									                	  var cloneLi = document.importNode(template.content, true);
										                  var spans = cloneLi.querySelectorAll("span");
										                  var p = cloneLi.querySelector("p")
										                  var img = cloneLi.querySelector("img");
										                    
									                	  spans[0].textContent=comments[i].memberId; 
									                	  spans[1].textContent=comments[i].regDate;
										                  p.textContent = comments[i].content;
										                        
										                  if(comments[i].profile !="")
										                  	img.src="${ctx}"+comments[i].profile;
										                  else
										                	  img.src="${ctx}/resources/images/chef.png";
										                  commentView.get(0).appendChild(cloneLi);      
									                 	 	}  
									            		}  
									            	   });    
												      //댓글등록 이벤트
												      submitButton.click(function(e){
												         e.preventDefault();
												        
												         var data = $(commentView).parent().parent().children().eq(2).children().eq(0).serialize();    
												         console.log(data);//data에는 내가 입력한 댓글의 내용이 들어간다
												         //Comment ajax reg        
												         $.post(listId+"/comment/reg", data, function(result){
												        	 console.log(result);      
												               if(parseInt(result)==1){  
												            	   //등록 comment를 포함한 리스트 ajax로 가져온다. 
												            	   $.getJSON(listId+"/ajax-comment-list", function(comments){
												            		console.log(comments.length);
												            		console.log(comments[0].memberId);
												            		commentView.empty();    
 
												                  
																  var template = document.querySelector('#comment-template');
																    
												                  //template 노드를 모두 복사하여 자식 노드에 comments json의 개수만큼 반복삽입
												                  for(var i=0; i < comments.length; i++ ){
												                	  
												                	  var cloneLi = document.importNode(template.content, true);
													                  var spans = cloneLi.querySelectorAll("span");
													                  var p = cloneLi.querySelector("p")
													                  var img = cloneLi.querySelector("img");
													                  
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