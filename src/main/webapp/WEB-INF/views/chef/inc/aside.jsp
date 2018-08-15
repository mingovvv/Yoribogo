<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

	<aside class="chef-aside">
		<nav>
			<h1 class="hidden">간편조작 버튼</h1>
			<ul>
				<li class="plus-button"><img src="${ctx}/resources/images/add.png" /></li>
				<li class="write-button"><a href="${ctx}/chef/recipe/reg"><img src="${ctx}/resources/images/write.png" /></a></li>
				
					<%-- <c:if test="${recipe.memberId==loginId}"> --%>
						<li class="edit-button"><a href="${ctx}/chef/recipe/edit"><img src="${ctx}/resources/images/edit-icon.png" /></a></li>
					<%-- </c:if> --%>
				
				<li class="timer-button"><img src="${ctx}/resources/images/count.png" /></li>
			</ul>
		</nav>
		
		<div class="timer">
			<input type="text" id="expireMin">
			:
			<input type="text" id="expireSecond">
			
			<button id="btnStartCountdown" onclick="startCountdown()">
			Start
			</button>
			<button id="btnStopCountdown" onclick="stopCountdown()">
			Stop
			</button>
		</div>
		<img class="time-end" src="${ctx}/resources/images/cookcook.png">
	</aside>
	
<script>
window.addEventListener("load", function(){
	var plusButton = document.querySelector(".plus-button");
	var writeButton = document.querySelector(".write-button");
	var editButton = document.querySelector(".edit-button");
	var timerButton = document.querySelector(".timer-button");
	var timer =document.querySelector(".timer");
	
	plusButton.onclick=function(){
		if(writeButton.classList.contains("show")==false){
			writeButton.classList.add("show");
			timerButton.classList.add("show");
			editButton.classList.add("show");
		}
		else{
			writeButton.classList.remove("show");
			timerButton.classList.remove("show");
			editButton.classList.remove("show");
		}
	}
	
	timerButton.onclick=function(){
		if(timer.classList.contains("show")==false){
			timer.classList.add("show");
		}
		else{
			timer.classList.remove("show");
		}
	}
	
});




var remainSec;
var autoExecTimer;

function countdown(expireSec) {
	var expireMin,expireSecond
    var day, hour, min, sec, mod;
    var countText;
    var cycle = 1; // 체크 주기 설정(1이면 1초에 한번)

    remainSec = expireSec - cycle;
    countText = "";

    if (remainSec >= 0) {

        // 남은일수
        day = Math.floor(expireSec / (3600 * 24));
        mod = expireSec % (24 * 3600);

        // 남은시간
        hour = Math.floor(mod / 3600);
        mod = mod % 3600;

        // 남은분
        min = Math.floor(mod / 60);

        // 남은초
        sec = mod % 60;
		
        //expireMin = min;
        //expireSecond = sec;
        
        /* countText += (day>0) ? (day + "일 ") : "";
        countText += (hour>0) ? hour + "시간 " : "";
        countText += min + "분 ";
        countText += sec + "초"; */
    }

    document.getElementById('expireMin').value = min;
    document.getElementById('expireSecond').value = sec;
    
    if (expireSec<=0) {
    	 	document.getElementById('expireMin').value = 00;
    	    document.getElementById('expireSecond').value = 00;
    	    
    	    setTimeout(function(){
    	    	 document.querySelector("main").style.opacity=0; 
    	    	 document.querySelector(".time-end").classList.add("show");
    		}, 100);
    	    setTimeout(function(){
    	    	document.querySelector("main").style.opacity=1; 
    	    	document.querySelector(".time-end").classList.remove("show");
    		}, 2100);

    	    btnStartCountdown.innerHTML = 'start';
			
        // 종료 후에 필요한 로직 구현
    }


    if (expireSec>0) {
    	autoExecTimer = setTimeout("countdown(remainSec)", cycle*1000);
    }
}

var a = 0 ;
function startCountdown() {
	var expireMin =  document.getElementById('expireMin').value;
	var expireSecond =  document.getElementById('expireSecond').value;
	var btnStartCountdown =  document.getElementById('btnStartCountdown');
	var expireSec;
	
	//if(expireMin.value !=0 && expireSecond.value !=0){
		if(a == 0){
			if (expireMin == "" && expireSecond=="") {
				alert("실행예약시간을 분이나 초로 입력하십시오.");
				return;
			}
		
			if(expireMin=="")
				expireMin=0;
			if(expireSecond=="")
				expireSecond=0;
			
			expireSec=parseInt((expireMin*60))+parseInt(expireSecond);
			countdown(expireSec);
				
			btnStartCountdown.innerHTML = 'pause';
			a = 1 ;
			}else{
				clearTimeout(autoExecTimer);
				a = 0;
				btnStartCountdown.innerHTML = 'start';
			}
}

	//else(메소드가 시작했다면)


function stopCountdown() {
	clearTimeout(autoExecTimer);
	document.getElementById('expireMin').value = 00;
	document.getElementById('expireSecond').value = 00;
	btnStartCountdown.innerHTML = 'start';
}



</script>
