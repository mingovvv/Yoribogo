<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />


<main>
<section class="container">
	<article class="half">
		<h1>Yoribogo</h1>
		<div class="tabs">
			<span class="tab signin"><a href="${ctx}/member/login">Sign in</a></span>
			<span class="tab signup active">Sign up</span>
		</div>
		
		
		<div class="content">
			<div class="signin-cont cont">
				<form method="post" enctype="multipart/form-data">
					<input type="text" name="id" class="inpt" required="required" placeholder="Your id"> 
					<input type="password" name="pwd" class="inpt" required="required" placeholder="Your password">
					<input type="text" name="name" class="inpt" required="required" placeholder="Your name"> 
					<input type="text" name="nickname" class="inpt" required="required" placeholder="Your nickname"> 
					<input type="text" name="email" class="inpt" required="required" placeholder="Your e-mail"> 
					
					
					<div class = "l-box">
					
					<input id="file" style="border: none;" type="file" name="photo" class="inpt" > 
					<img id="photo"
						src="${ctx}/resources/images/profile.png"
						style="width: 120px; height: 120px; border: 1px solid #595959;  box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.15);" />
					</div>
					
					
					
					
					
					
					<div class="submit-wrap">
						<input type="submit" value="Sign up" class="submit"> <a href="#" class="more">Terms and conditions</a>
					</div>
				
				
				</form>
			</div>
			

		</div>
	</article>
	
	
	<div class="half bg">
		<img src="${ctx}/resources/images/login-door.png">
	</div>
</section>
</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script> 
<script type="text/javascript">
	$('.tabs .tab').click(function() {
		if ($(this).hasClass('signin')) {
			$('.tabs .tab').removeClass('active');
			$(this).addClass('active');
			$('.cont').hide();
			$('.signin-cont').show();
		}
		if ($(this).hasClass('signup')) {
			$('.tabs .tab').removeClass('active');
			$(this).addClass('active');
			$('.cont').hide();
			$('.signup-cont').show();
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
});
</script>
    