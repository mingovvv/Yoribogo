<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

	<header class="header">
		<h1><img src="${ctx}/resources/images/yoribogo.png" height="50px"></h1>

		<nav class="main-menu">
			<h1 class="hidden">메인메뉴</h1>
			<ul>
				<li><a href="${ctx}/chef/index"><img class="logo" src="${ctx}/resources/images/yoribogo-logo.png"/></a></li>
				<li id = "search-button"><a href="#"><img src="${ctx}/resources/images/ic_search_black_24dp_1x.png"/></a></li>
				
				<li id = "menu-button">
					<a href="#"><img src="${ctx}/resources/images/ic_dehaze_black_24dp_1x.png"/></a>
				</li>
			</ul>
		</nav>
		
		<form>
			<div class="search-recipe">
				<div>
					<input type="text" name="search-recipe" placeholder="찾으시는 레시피를 검색해주세요 :)" />
					<input type="submit" value="검색" /> 
					
				</div>
			</div>
		</form>
		
		
		<div class="add-memu">
			<ul>
				<li><span style="color: #49c5b6">min</span>님 안녕하세요!</li>
				<li>Mypage</li>
				<li><a href="${ctx}/chef/index" style="color: #49c5b6">Home</a></li>
				<li><a href="${ctx}/chef/recipe/list">Recipe</a></li>
				<li><a href="#">Community</a></li>
				<li><a href="#">냉장고를 부탁해</a></li>
				<li><a href="#">About us</a></li>
				<li><a href="${ctx}/logout">Log-Out</a></li>
			</ul>
		</div>
	</header>
	
<script>
window.addEventListener("load", function(){
	var menuButton = document.querySelector("#menu-button");
	var addMemu = document.querySelector(".add-memu");
	var visual = document.querySelector(".visual");
	var main = document.querySelector(".main");
	var footer = document.querySelector(".footer");
	
	var searchButton = document.querySelector("#search-button");
	var searchRecipe = document.querySelector(".search-recipe");

	
	
	
	menuButton.onclick=function(){
		if(addMemu.classList.contains("show")==false){
			addMemu.classList.add("show");
			
			visual.classList.add("show");
			main.classList.add("show");
			footer.classList.add("show");
			
		}
		else{
			addMemu.classList.remove("show");
			
			visual.classList.remove("show");
			main.classList.remove("show");
			footer.classList.remove("show");
		}
	}
	
	searchButton.onclick=function(){
		if(searchRecipe.classList.contains("show")==false){
			searchRecipe.classList.add("show");
			
		}
		else{
			searchRecipe.classList.remove("show");
		}
		
	}
	
});
</script>