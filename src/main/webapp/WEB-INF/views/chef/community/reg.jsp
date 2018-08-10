<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<main class="main">
		<!-- 게시글 등록 폼 -->
		<form>
		<section id="community-section">
			<div class="community-main">
				<!-- 작성자 데이터 가져올 것. -->
				<div class="member-info">
					<div class="member-img"></div>
					<div class="member-id"></div>
				</div>
				<!-- 편집기 사용 -->
				<div class="content-main">
					<div class="content">
						<div class="content-img"></div>
						<div class="content-text"></div>
					</div>	
				</div>
			</div>
		</section>
		<!-- 등록/취소 버튼 -->
		<div class="">
			<button class="submit" type="submit"></button>
			<button class="cancel" type="button"></button>
		</div>
		</form>
	</main> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
</script>