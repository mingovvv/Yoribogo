<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
		
		<form class="a">
			<div>
				<span>종류별</span>
				<br>
					<div>
					<input type="checkbox" value="#" checked="checked" />전체
					<input type="checkbox" value="#"/>한식
					<input type="checkbox" value="#"/>일식
					<input type="checkbox" value="#"/>중식
					<input type="checkbox" value="#"/>양식
					<input type="checkbox" value="#"/>기타
					</div>
				<br>
				<br>
				<span>상황별</span>
				<br>
					<div>
					<input type="checkbox" value="#" checked="checked"/>전체
					<input type="checkbox" value="#"/>일상
					<input type="checkbox" value="#"/>다이어트
					<input type="checkbox" value="#"/>안주
					<input type="checkbox" value="#"/>건강
					<input type="checkbox" value="#"/>간식
					<input type="checkbox" value="#"/>야식
					<input type="checkbox" value="#"/>기타
					</div>
				<br>
				<br>
				<span>시간별</span>
				<br>
					<div>
					<input type="checkbox" value="#" checked="checked"/>전체
					<input type="checkbox" value="#"/>15분
					<input type="checkbox" value="#"/>30분
					<input type="checkbox" value="#"/>1시간
					<input type="checkbox" value="#"/>2시간
					<input type="checkbox" value="#"/>2시간 이상
					</div>
			</div>
			
			<input type="submit" value="검색"/>
			
			<nav class="select-recipe-option2">
				<h1 class="hidden">레시피 분류</h1>
				<img class="menu-down-button" src="${ctx}/resources/images/caret-down.png">
			</nav>
		</form>
		
		<nav class="select-recipe-view">
			<ul>
				<li class="date-button">Date</li>
				<li class="pop-button">Popularity</li>
				<li class="ran-button">Random</li>
			</ul>
		</nav>
 		<section class="recipe-list">  
			<h1 class="hidden">레시피목록</h1>
			<ul>
			
				<c:forEach var="recipe" items="${recipe}">
				
					<li>
						<div class = "frame">
							<div>
								<a href="${recipe.id}">
									<img src="${ctx}${recipe.representativeImage}">
								</a>
							</div>
							<div>${recipe.title}</div>
							<div>
								<div>${recipe.memberId}</div>
								<div> 
								
								   
										<c:set var="test" value="0" />
										
										<c:forEach var="recipeLike" items="${recipeLike}">
											<c:if test="${recipeLike.recipeId == recipe.id}">
												<c:set var="test" value="1" />
											</c:if>
										</c:forEach >
										
										
											<c:if test="${test==1}">
												<img class="like-button" name="${recipe.id}" src="${ctx}/resources/images/like.png" style="cursor: pointer;">
											</c:if>
											<c:if test="${test==0}">
												<img class="like-button" name="${recipe.id}" src="${ctx}/resources/images/unlike.png" style="cursor: pointer;">
											</c:if>											
								</div>
							</div>
						</div>       
					</li>
					      
				</c:forEach> 
				  
			</ul>
		</section> 
	</main>
	
	
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
  $(".like-button").click(function(){
    var recipeId = $(this).attr('name')
    console.log(recipeId);
    console.log("${ctx}/chef/recipe/"+recipeId+"/like");
    $.ajax({ // .like-button 버튼을 클릭하면 <새로고침> 없이 ajax로 서버와 통신하겠다.
      type: "POST", // 데이터를 전송하는 방법을 지정
      url: "${ctx}/chef/recipe/"+recipeId+"/like",
      data: {"recipeId": recipeId}, // 서버로 데이터 전송시 옵션
      dataType: "json", // 서버측에서 전송한 데이터를 어떤 형식의 데이터로서 해석할 것인가를 지정, 없으면 알아서 판단
      // 서버측에서 전송한 Response 데이터 형식 (json)
      
      
      success: function(data){ // 통신 성공시 - 동적으로 좋아요 갯수 변경, 유저 목록 변경
        var selector = $("img[name="+recipeId+"]");
        console.log(data);
        
      	if(selector.attr('src')=='/yoribogo/resources/images/like.png'){
        	$("img[name="+recipeId+"]").attr("src","${ctx}/resources/images/unlike.png")
        	alert("즐겨찾기에 삭제 하셨습니다");
        console.log(selector.attr('src'));} 
      	else//(selector.attr('src')=='/yoribogo/resources/images/unlike.png')
        	{$("img[name="+recipeId+"]").attr("src","${ctx}/resources/images/like.png")   
      		alert("즐겨찾기에서 추가 하셨습니다");
        console.log(selector.attr('src'));}   
       //$("#count-"+pk).html(response.like_count+"개");
        //var users = $("#like-user-"+pk).text();
        //if(users.indexOf(response.nickname) != -1){
        //  $("#like-user-"+pk).text(users.replace(response.nickname, ""));
        //}else{
        //  $("#like-user-"+pk).text(response.nickname+users);
        //}      
      },
      error: function(request, status, error){ // 통신 실패시 - 로그인 페이지 리다이렉트
        alert("통신실패")
      },
    });   
  })
</script>
<script>
window.addEventListener("load", function(){
	var likeButton = document.querySelectorAll(".like-button");
	var menuDownButton = document.querySelector(".menu-down-button");
	var selectRecipeOption2 = document.querySelector(".select-recipe-option2");
	var a = document.querySelector(".a");
	var selectRecipeViewButton = document.querySelectorAll(".select-recipe-view ul li");
	var dateButton = document.querySelector(".date-button");
	var popButton = document.querySelector(".pop-button");
	var ranButton = document.querySelector(".ran-button");
	
	
    /* for(var i=0;i<likeButton.length;i++){
    	(function(m) {
    		likeButton[m].onclick = function(){
    			if(likeButton[m].src.match("unlike")){
					alert("레시피 저장고에 등록되었습니다 :)");   				
    				likeButton[m].src = "${ctx}/resources/images/like.png";
    			}
    			else{
    				likeButton[m].src = "${ctx}/resources/images/unlike.png";
    				alert("레시피 저장고에서 삭제 되었습니다 :)");  				
    			}
    		}
    	})(i);
	};  */
	
	dateButton.onclick = function(){
		dateButton.style.background="#5fcad4";
		popButton.style.background="#95a5a3";
		ranButton.style.background="#95a5a3";
	}
	popButton.onclick = function(){
		dateButton.style.background="#95a5a3";
		popButton.style.background="#5fcad4";
		ranButton.style.background="#95a5a3";
	}
	ranButton.onclick = function(){
		dateButton.style.background="#95a5a3";
		popButton.style.background="#95a5a3";
		ranButton.style.background="#5fcad4";
	}
	
	

	 menuDownButton.onclick = function(){
		if(a.classList.contains("show")==false){
			a.classList.add("show");
			menuDownButton.src = "${ctx}/resources/images/caret-arrow-up.png";
		}
		else{
			a.classList.remove("show");
			menuDownButton.src = "${ctx}/resources/images/caret-down.png";
		}
	}; 


});
	
	

</script>