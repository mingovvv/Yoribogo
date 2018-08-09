<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

	<main class="main">
	<h1>Community!!!!!</h1>
		<!-- style 변경 버튼 -->
		<div class="community-view-style-btn">
			<form action="..." method="GET" >
				<input type="button" class="btn" value="change-style"/>
			</form>
		</div>         
		<!-- 게시글 디폴트 형식 -->      
		<section id="community-section">
			<div class="community-main">        
				<div class="member-info">
					<div class="member-img">img</div>
					<div class="member-id">memberid</div>
				</div>    
				<div class="content-main">    
					<div class="reg-date">regdate</div>
					<div class="content">
						<div class="content-img"></div>
						<div class="content-text">안녕하세요 요리보고 장민규 사장님의 동생 황상진입니다. 잘 부탁드려요~~ 제가만든 요리입니다~</div>
					</div>	
				</div>
				<!-- more 클릭 시 css auto로 확장, 댓글섹션 생성 -->
				<section class="comment-section">
				<!-- foreach로 댓글 모두 불러올 것. -->
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
				<!-- 댓글 입력 구현(ajax post) -->	
					<div class="comment-reg">
						<div class="input-text"></div>
						<div class="reg-btn"></div>
					</div>
				</section>
			</div>
			<!-- 하단 more버튼, 클릭 반복시 이모티콘 바뀐다. -->	
			<div class="community-more">
				<div class="more-icon"></div>
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

  </script>