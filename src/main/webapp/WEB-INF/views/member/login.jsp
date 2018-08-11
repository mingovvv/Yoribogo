<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
    
<main>
<section class="container">
	<article class="half">
		<h1>Yoribogo</h1>
		<div class="tabs">
			<span class="tab signin active">Sign in</span>
			<span class="tab signup"><a href="${ctx}/member/join">Sign up</a></span>
		</div>
		
		
		<div class="content">
			<div class="signin-cont cont">
				<form method="post">
					<input type="text" name="username" class="inpt" required="required" placeholder="user id"> 
					<input type="password" name="password" class="inpt" required="required" placeholder="Your password"> 
					
					<input type="checkbox" id="remember" class="checkbox" checked> <label for="remember">Remember me</label>
					<div class="submit-wrap">
						<input type="submit" value="Sign in" class="submit"> 
						<a href="#" class="more">Forgot your password?</a>
					</div>
				</form>
			</div>
			
			
<!-- 			<div class="signup-cont cont">
				<form method="post">  enctype="multipart/form-data"

					<input type="text" name="id" id="id" class="inpt" required="required" placeholder="Your id"> 
					<input type="password" name="pwd" id="pwd" class="inpt" required="required" placeholder="Your password">
					<input type="text" name="name" id="name" class="inpt" required="required" placeholder="Your name"> 
					<input type="text" name="nickname" id="nickname" class="inpt" required="required" placeholder="Your nickname"> 
					<input type="text" name="email" id="email" class="inpt" required="required" placeholder="Your e-mail"> 
					<input type="file" name="photo" id="photo" class="inpt" > 
					
					<div class="submit-wrap">
						<input type="submit" value="Sign up" class="submit"> <a href="#" class="more">Terms and conditions</a>
					</div>
				</form>
			</div> -->
			
			
		</div>
	</article>
	
	
	<div class="half bg">
		<img src="${ctx}/resources/images/login-door.png">
	</div>
</section>
</main>

<%-- <main>
	<section>
		<h1>로그인 폼</h1>
		<form action="${ctx}/login" method="post">
			<fieldset>
				<legend>로그인필드</legend>
				<table>
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="username" placeholder="아이디를 입력하세요" /></td>
					</tr>
					<tr>
						<td>패스워드 : </td>
						<td><input type="password" name="password" placeholder="패스워드를 입력하세요" /></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="로그인" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</section>
</main> --%>


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