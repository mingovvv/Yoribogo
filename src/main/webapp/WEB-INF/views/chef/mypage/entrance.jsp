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
							<ul>
							
								<c:forEach begin="0" end="3">
								
									<li>
										<div class = "frame">
											<div><img src="${ctx}/resources/images/sample-images.png"></div>
											<div>모두가 좋아하는 등갈비 </div>
											<div>
												<div>by 자취왕</div>
												<div><a href="#"><img class="like-button" src="${ctx}/resources/images/unlike.png"></a></div>
											</div>
										</div>
									</li>
									
								</c:forEach>
								
							</ul>
						</section>
			</div>
			<div class="like-recipe">
				<span>즐겨찾기</span>
						<section class="recipe-list">
							<h1 class="hidden">레시피목록</h1>
							<ul>
							
								<c:forEach begin="0" end="3">
								
									<li>
										<div class = "frame">
											<div><img src="${ctx}/resources/images/sample-images.png"></div>
											<div>모두가 좋아하는 등갈비 </div>
											<div>
												<div>by 자취왕</div>
												<div><a href="#"><img class="like-button" src="${ctx}/resources/images/unlike.png"></a></div>
											</div>
										</div>
									</li>
									
								</c:forEach>
								
							</ul>
						</section>
			</div>
		</div>
	</div>
</main>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script>
window.addEventListener("load", function(){
	var settingButton = document.querySelector(".setting");
	var profileButton = document.querySelector(".profile");
	var modifyMember = document.querySelector(".modify-member");
	var cancelButton = document.querySelector(".cancel-image");
	

	settingButton.onclick=function(){
		modifyMember.classList.add("show");
	}
	
	cancelButton.onclick=function(){
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
