<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">

	<img src="${ctx}/resources/images/mypage_main(2).png" style="width: 100%">
	<div class="entrance-container">
					<c:if test="${member.photo == null}">
					<img class="profile" src="${ctx}/resources/images/chef.png">
					</c:if>
					
					<c:if test="${member.photo != null}">
					<img class="profile" src="${ctx}${member.photo}" style="border-radius:  195px;margin-top: 155px;" width="195px" height="195px">
					</c:if> 
		<p>${member.id}
			<img class="setting" src="${ctx}/resources/images/settings.png">
		</p>
		
		<div class="modify-member">
			<img class="cancel-image" src="${ctx}/resources/images/remove-symbol.png">
			<section class="container">
				<article class="half">
					<h1>개인정보 수정</h1>
					
					
					<div class="content">
						<div class="signin-cont cont">
							<form method="post" enctype="multipart/form-data">
								<div class = "l-box">
								
								<c:if test="${member.photo == null}">
								<img id="photo"
									src="${ctx}/resources/images/chef.png"
									style="width: 120px; height: 120px; margin-left: auto; margin-right: auto; border-radius: 60px" />
								</c:if>
								
								<c:if test="${member.photo != null}">
								<img id="photo"
									src="${ctx}${member.photo}"
									style="width: 120px; height: 120px; margin-left: auto; margin-right: auto; border-radius: 60px" />
								</c:if> 
								
								</div>
								<input id="file" style="border: none" type="file" name="file" class="inpt" > 
								<span id="fixed-id" style="line-height: 10px;font-size: 20px;">${member.id}</span>
								<input type="password" name="pwd" class="inpt" required="required" placeholder="Change Your password">
								<input type="text" name="name" class="inpt" required="required" placeholder="Change Your name"> 
								<input type="text" name="nickname" class="inpt" required="required" placeholder="Change Your nickname"> 
								<input type="text" name="email" class="inpt" required="required" placeholder="Change Your e-mail"> 
								
								
								
								
								
								
								
								
								<div class="submit-wrap">
									<input type="submit" value="수정하기" class="submit">
								</div>
							
							
							</form>
						</div>
						
			
					</div>
				</article>
	
	
	<div class="half bg">
		<img src="${ctx}/resources/images/login-door.png">
	</div>
</section>

		</div>
		
		
		<div class="my-content">
			<div class="written-recipe">
				<span>내가 작성한 레시피</span>
						<section class="recipe-list">
							<h1 class="hidden">레시피목록</h1>
							
								<c:if test="${empty recipe}">
									<span class="fix"> 등록하신 레시피가 없습니다 :)</span><br />
									<a href="${ctx}/chef/recipe/reg">
									<span class="fix" style="font-size: 15px; color: #ff4b6a;"><b>레시피를 등록하기</b>
									<img src="${ctx}/resources/images/pen.png">
									</span>
									</a>
								</c:if>   

								<c:if test="${not empty recipe}">
							<ul>
				
			
									<c:forEach var="recipe" items="${recipe}">
				
										<li>
											<div class="frame">
												<div>
													<a href="${ctx}/chef/recipe/${recipe.id}"> <img
														src="${ctx}${recipe.representativeImage}">
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
														</c:forEach>
				
				
														<c:if test="${test==1}">
															<img class="like-button" name="${recipe.id}"
																src="${ctx}/resources/images/like.png"
																style="cursor: pointer;">
														</c:if>
														<c:if test="${test==0}">
															<img class="like-button" name="${recipe.id}"
																src="${ctx}/resources/images/unlike.png"
																style="cursor: pointer;">
														</c:if>
													</div>
												</div>
											</div>
										</li>
				
									</c:forEach>
			</ul>
								</c:if>

						</section>
			</div>
			<div class="like-recipe">
				<span>즐겨찾기</span>
						<section class="recipe-list">
							<h1 class="hidden">레시피목록</h1>
							<ul>

								<c:if test="${empty likeRecipe}">
									<span> 즐겨찾기 하신 레시피가 없습니다 :) </span>
								</c:if>
								<c:if test="${not empty likeRecipe}">
				
				
				
									<c:forEach var="likeRecipe" items="${likeRecipe}">
				
										<li>
											<div class="frame">
												<div>
													<a href="${ctx}/chef/recipe/${likeRecipe.id}"> <img
														src="${ctx}${likeRecipe.representativeImage}">
													</a>
												</div>
												<div>${likeRecipe.title}</div>
												<div>
													<div>${likeRecipe.memberId}</div>
													<div>
				
				
														<c:set var="test" value="0" />
				
														<c:forEach var="recipeLike" items="${recipeLike}">
															<c:if test="${recipeLike.recipeId == likeRecipe.id}">
																<c:set var="test" value="1" />
															</c:if>
														</c:forEach>
				
				
														<c:if test="${test==1}">
															<img class="like-button" name="${likeRecipe.id}"
																src="${ctx}/resources/images/like.png"
																style="cursor: pointer;">
														</c:if>
														<c:if test="${test==0}">
															<img class="like-button" name="${likeRecipe.id}"
																src="${ctx}/resources/images/unlike.png"
																style="cursor: pointer;">
														</c:if>
													</div>
												</div>
											</div>
										</li>
				
									</c:forEach>
								</c:if>

			</ul>
						</section>
			</div>
		</div>
	</div>
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script type="text/javascript">
  $(".like-button").click(function(){
    var recipeId = $(this).attr('name')
    
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
	window.addEventListener("load", function() {
		var settingButton = document.querySelector(".setting");
		var profileButton = document.querySelector(".profile");
		var modifyMember = document.querySelector(".modify-member");
		var cancelButton = document.querySelector(".cancel-image");

		settingButton.onclick = function() {
			modifyMember.classList.add("show");
		}

		cancelButton.onclick = function() {
			modifyMember.classList.remove("show");
		}

	});
</script>
<script>
function readURL(input) {
	 
    if (input.files && input.files[0]) {
        var reader = new FileReader();
 
        reader.onload = function (e) {
            $('#photo').attr('src', e.target.result);
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}
 
$("#file").change(function(){
    readURL(this);
    console.log(this);
});

</script>
