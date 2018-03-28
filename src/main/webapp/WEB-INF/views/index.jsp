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
				<li><a href="#"><img src="resources/images/ic_dehaze_black_24dp_1x.png"/></a></li>
			</ul>
		</nav>
	</header>
	
	<main class="main">
		<section class="recipe-list">
			<h1 class="hidden">레시피목록</h1>
			<ul>
				<c:forEach begin="0" end="9">
				<li>
					<div><img src="resources/images/sample-images.png"/></div>
					<div>등갈비 만들기</div>
					<div>자취맨</div>
					<div><img src="resources/images/empty-heart.png"></div>
				</li>
				</c:forEach>
			</ul>
		</section>
	</main>
	
</body>
</html>