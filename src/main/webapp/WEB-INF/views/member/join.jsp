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
				<form method="post" enctype="multipart/form-data" id="form">  <!-- enctype="multipart/form-data" -->
					<input type="text" id="id" class="inpt" required="required" placeholder="your id" autocomplete=off> 
					<!-- <input type="button" class="checkbtn" style="width:100px; height:30px;" value="check"> -->
					<div class="check-id">*영문,숫자 포함  4~12자</div>
					                                     
					<input type="password" id="pwd" class="inpt" required="required" placeholder="your password">
					<div class="check-pwd">*영문,숫자 포함  4~12자</div>
					
					<input type="text" name="name" id="name" class="inpt" required="required" placeholder="your korean-name"> 
					<input type="text" name="nickname" id="nickname" class="inpt" required="required" placeholder="Your nickname"> 
					<input type="text" name="email" id="email" class="inpt" required="required" placeholder="Your e-mail"> 
					  
					<div class = "l-box">
					
					<input id="file" style="border: none" type="file" name="file" class="inpt" > 
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



<script>
//-------------------------유효성 검사----------------------------------------------
$(document).ready(function(){ //DOM이 준비되고

	var id = $('#id').val();
	var pwd = $('#pwd').val();
	var name = $('#name').val();
	var nickname = $('#nickname').val();
	var email = $('#email').val();
	
	
	//유효성 검사 정규식
	var exp1 = /^[a-zA-Z0-9]{4,12}$/;                        
	var exp2 = /[가-힝]{2,}$/;
	var exp3 = /[a-z0-9]{2,}@[a-z0-9-]{2,}\.[a-z0-9]{2,}/i;
 
              
	  $('#id').keyup(function(){	  
		$.ajax({
            type: 'POST',
            url: '/yoribogo/member/join/checkId',
            data: {
                'memberId' : $('#id').val()
            },
            dataType:'html',                
            success: function(data){
                              
               if(data == "none"){
            	                                                                  
               		if(!exp1.test($('#id').val())){                              
               			
                        $('#id').css('background','#FFCC00');
                        $('#id').removeAttr("name");
                        $('.check-id').css('color','red');
            			$('.check-id').text('*영문,숫자 포함  4~12자');
                        
                       
               		}                                    
               		else{
                   $('#id').css('background','#CCFF00');
                   $('#id').attr("name", "id");
                   $('.check-id').css('color','green');
       			   $('.check-id').text('OK');
       			   }                         
               		                    
               }                     
               else if(data =="exist"){
     
    	            $('#id').css('background','#FFCC00');
    	            $('#id').removeAttr("name");
    	            $('.check-id').css('color','red');
        			$('.check-id').text('*아이디가 이미 존재합니다.');
    	            //return false;
               }                                                 
            
            },
            /* complete : function(data) {
				alert("not connect");
                // 통신이 실패했어도 완료가 되었을 때 이 함수를 타게 된다.

            }, */
            error:function(request,status,error){
               alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
              }           
        }); 
    });          
	                          
	  
	$('#pwd').keyup(function(){
                                                              	
		if(!exp1.test($('#pwd').val())){                              
            $('#pwd').css('background','#FFCC00');
            $('#pwd').removeAttr("name");
            $('.check-pwd').css('color','red');
			$('.check-pwd').text('*영문,숫자 포함  4~12자');
            //return false;
   		}
		else{
                                         
       $('#pwd').css('background','#CCFF00');
       $('#pwd').attr("name", "pwd");
       $('.check-pwd').css('color','green');
	   $('.check-pwd').text('OK');
   		}                      
		
	});                            
	                                                                                                                                                                                                                                                                                                                                                             
	$('#form').submit(function(){
		if($('#id').attr('name') == null){
			alert("id check please");
			$('#id').val('');
			$('#id').focus();
			return false;
		}                       
		else if($('#pwd').attr('name') == null){
			alert("pwd check please");
			$('#pwd').val('');                                                 
			$('#pwd').focus();
			return false;
		}
		else if(!exp2.test($('#name').val())){
			alert("올바른 이름 형식이 아닙니다.");
			$('#name').val('');
			$('#name').focus();
			return false;
		}
		else if(!exp3.test($('#email').val())){
			                                                                                             
			$('#email').val('');
			$('#email').focus();
			alert("올바른 이메일 형식이 아닙니다.");                                  
			return false;
		}
	});
});
		
</script>
