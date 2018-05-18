<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

<main class="main">
	<div class="detail-container">
		<div class="representative-img">
			<img alt="" src="${ctx}/resources/images/sam.jpg">
			<div class="profile">
				<img alt="" src="${ctx}/resources/images/cook-profile.png">
				<span>pika</span> 
			</div>
		</div>
		
		<div class="detail-main">
			<ul class="semi-box">
				<li><img alt="" src="${ctx}/resources/images/eye.png" style="border: 3px solid black"><span>조회수 <b style="color:black ">30회</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/chat.png" style="border: 3px solid #6b6bd9"><span>댓글 <b style="color:#6b6bd9 ">40개</b></span></li>
				<li><img alt="" src="${ctx}/resources/images/kitchen.png" style="border: 3px solid #dbc77e"><span>즐겨찾기 <b style="color:#938658 ">30개</b></span></li>
			</ul>
			<p class="detail-title">디테일 제목</p>
			<p class="detail-content">디테일 내용디테일 내용디테일 내용디테일 내용디테일 
			디테일 내용디테일 내용디테일 내용디테일 내용디테일 내용디테일 내용 내용디테일 내용디테일 내용디테일 내용디테일 내용디테일 내용</p>
		</div>
		
		<div class="using-ingredient">
			<h1>사용된 재료</h1>
			<span>돼지고기</span>
			<span>오이</span>
			<span>양파</span>
			<span>간장</span>
		</div>
		
		<div class="step-order">
			<h1>Step</h1>
			<span>Step 1</span>
			<div>
				<img src="${ctx}/resources/images/sample-images.png">
			</div>
			<p>동해물과 백두산이 마르고 닳도록~</p>
			
			<span>Step 1</span>
			<div>
				<img src="${ctx}/resources/images/sample-images.png">
			</div>
			<p>동해물과 백두산이 마르고 닳도록~</p>
			
			<span>Step 1</span>
			<div>
				<img src="${ctx}/resources/images/sample-images.png">
			</div>
			<p>동해물과 백두산이 마르고 닳도록~</p>
			
			<span>Step 1</span>
			<div>
				<img src="${ctx}/resources/images/sample-images.png">
			</div>
			<p>동해물과 백두산이 마르고 닳도록~</p>
			
			<span>Step 1</span>
			<div>
				<img src="${ctx}/resources/images/sample-images.png">
			</div>
			<p>동해물과 백두산이 마르고 닳도록~</p>
		</div>
		
		<div class="reply-window">
			<h1 class="hidden">댓글 창</h1>
			<p>댓글 <span style="color: #5fcad4">1</span></p>
			<div>
				<div><img alt="" src=""></div>
				<p>pika 2018-05-18 23:00</p>
				<p>정말 멋지네요 ^^ 정말 멋지네요 ^^ 정말 멋지네요 ^^ 정말 멋지네요 ^^ 정말 멋지네요 ^^</p>
			</div>
			
		
			
		
		
		
		
		
		
		
		
		
		
		<section class="comment-form" id="comment-form">
         <form action="" method="post">
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
		
	</div>
</main>   