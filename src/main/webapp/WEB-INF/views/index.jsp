<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport" content="width=device-width,  initial-scale=1 minimum-scale=1 user-scalable=1">


<title>Insert title here</title>
<link href="resources/CSS/style.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<header class="header">
		<h1>Yoribogo</h1>

		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>
				<li><a href="#"><img class="logo" src="resources/images/logo-joof.png"/></a></li>
				<li><a href="#"><img src="resources/images/ic_search_black_24dp_1x.png"/></a></li>
				
				<li id = "menu-button">
					<a href="#"><img src="resources/images/ic_dehaze_black_24dp_1x.png"/></a>
				</li>
			</ul>
		</nav>
		<div class="add-memu">
			<ul>
				<li>Login</li>
				<li>Recipe</li>
				<li>Community</li>
				<li>냉장고를 부탁해</li>
			</ul>
		</div>
	</header>
	
	<div class="visual">
		<div class="change-image"><img src="resources/images/main-image.png"></div>
	</div>
	
	<main class="main">
		<section class="recipe-list">
			<h1 class="hidden">레시피목록</h1>
			<ul>
			
				<c:forEach begin="0" end="30">
				
					<li>
						<div class = "frame">
							<div><!-- <img src="resources/images/sample-images.png"/> --></div>
							<div>등갈비 만들기</div>
							<div>
								<div><!-- <img src="resources/images/empty-heart.png"> --></div>
								<div>by 만가지요리</div>
							</div>
						</div>
					</li>
					
				</c:forEach>
				
			</ul>
		</section>
	</main>
<footer class = "footer">
	
주소:
서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호
관리자메일:
admin@newlecture.com
사업자 등록번호:
132-18-46763
통신 판매업:
신고제 2013-서울강동-0969 호
상호:
뉴렉처
대표:
박용우
전화번호:
070-4206-4084
Copyright ⓒ newlecture.com 2012-2014 All Right Reserved. Contact admin@newlecture.com for more information
</footer>
	
</body>
</html>

<script>
window.addEventListener("load", function(){
	var menuButton = document.querySelector("#menu-button");
	var addMemu = document.querySelector(".add-memu");
	var visual = document.querySelector(".visual");
	var main = document.querySelector(".main");
	
	menuButton.onclick=function(){
		if(addMemu.classList.contains("show")==false){
			addMemu.classList.add("show");
			visual.style.opacity="0.2";
			main.style.opacity="0.2";
		}
		else{
			addMemu.classList.remove("show");
			visual.style.opacity="1";
			main.style.opacity="1";
		}
	}
});
</script>