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
				<form method="post">
					<input type="text" name="id" class="inpt" required="required" placeholder="Your id"> 
					<input type="password" name="pwd" class="inpt" required="required" placeholder="Your password">
					<input type="text" name="name" class="inpt" required="required" placeholder="Your name"> 
					<input type="text" name="nickname" class="inpt" required="required" placeholder="Your nickname"> 
					<input type="text" name="email" class="inpt" required="required" placeholder="Your e-mail"> 
					<input type="file" name="photo" class="inpt" > 
					
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
    
<%-- <main>
<section class="container">
	<article class="half">
		<h1>Yoribogo</h1>
		<div class="tabs">
			<span class="tab signin"><a href="${ctx}/member/login">Sign in</a></span>
			<span class="tab signup active">Sign up</span>
		</div>
		
		
			<div class="signup-cont cont">
				<form method="post"> <!-- enctype="multipart/form-data" -->

					<input type="text" name="id" class="inpt" required="required" placeholder="Your id"> 
					<input type="password" name="pwd" class="inpt" required="required" placeholder="Your password">
					<input type="text" name="name" class="inpt" required="required" placeholder="Your name"> 
					<input type="text" name="nickname" class="inpt" required="required" placeholder="Your nickname"> 
					<input type="text" name="email" class="inpt" required="required" placeholder="Your e-mail"> 
					<input type="file" name="photo" class="inpt" > 
					
					<div class="submit-wrap">
						<input type="submit" value="Sign up" class="submit"> <a href="#" class="more">Terms and conditions</a>
					</div>
				</form>
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
</script> --%>




<!-- <main>
	<section>
		<h1>회원 가입폼</h1>
		<form method="post">
			<fieldset>
				<legend>로그인필드</legend>
				<table>
					<tr>
						<td>아이디 : </td>
						<td><input type="text" name="id" placeholder="6~12자 이내로" /></td>
					</tr>
					<tr>
						<td>패스워드 : </td>
						<td><input type="password" name="pwd"  /></td>
					</tr>
					<tr>
						<td>이름 : </td>
						<td><input type="text" name="name"  /></td>
					</tr>
					<tr>
						<td>닉네임 : </td>
						<td><input type="text" name="nickname"  /></td>
					</tr>
					<tr>
						<td>이멜 : </td>
						<td><input type="text" name="email"  /></td>
					</tr>
					<tr>
						<td>사진 : </td>
						<td><input type="file" name="file"/></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="submit" value="가입하기" />
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</section>
</main> -->