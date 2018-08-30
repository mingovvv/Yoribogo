<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<main class="main" style="margin:0px; " > 
 
<!--  <p>요리보고와 함께 즐거운 요리 어떠세요? </p> -->
 	<div>
		<section class="recipe-list">
			<h1 class="hidden">레시피목록</h1>
			<ul style="flex-wrap: nowrap; overflow: hidden; height: auto;">
			
				<c:forEach var="recipe" items="${recipe}">
				
						<li style="display: inline-block;">
						 
						
							<div class="frame" style="margin: 0;">
								<div>
									<a href="recipe/${recipe.id}">
									<img src="${ctx}${recipe.representativeImage}">
									</a>
								</div>
								<div style="overflow: -webkit-paged-y;">${recipe.title}</div>
								<div>
									<div style="font-size: 18px">${recipe.memberId}</div>
									<div style="color: #d07376; position: absolute; right: 0%; bottom:  0%;" >${recipe.sortTime}</div>
								</div>
							</div>
							
							   
						</li>
				
					</c:forEach>  
				 
			</ul>


</div>		
		     
			</section>
</main>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${ctx}/resources/js/jquery.liMarquee.js"></script>
<script>    
	$('.recipe-list ul').liMarquee({
		direction: 'left',	
		loop:-1,			
		scrolldelay:0,		
		scrollamount:100,	
		circular: true,		
		drag: true			
	});  
</script>