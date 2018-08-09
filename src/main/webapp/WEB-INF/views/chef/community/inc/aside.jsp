<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

	<aside class="chef-aside">
		<nav>
			<h1 class="hidden">간편조작 버튼</h1>
			<ul>
				<li class="plus-button"><img src="${ctx}/resources/images/add.png" /></a></li>
				<li class="write-button"><a href="${ctx}/chef/recipe/reg"><img src="${ctx}/resources/images/write.png" /></a></li>
			</ul>
		</nav>
		
	</aside>
	
<script>
window.addEventListener("load", function(){
	var plusButton = document.querySelector(".plus-button");
	var writeButton = document.querySelector(".write-button");
	
	plusButton.onclick=function(){
		if(writeButton.classList.contains("show")==false){
			writeButton.classList.add("show");
		}
		else{
			writeButton.classList.remove("show");
		}
	}
	
});
</script>
