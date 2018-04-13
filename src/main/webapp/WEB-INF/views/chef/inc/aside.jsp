<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />

	<aside class="chef-aside">
		<nav>
			<h1 class="hidden">간편조작 버튼</h1>
			<ul>
				<li class="plus-button"><a href="#"><img src="${ctx}/resources/images/add.png" /></a></li>
				<li class="write-button"><a href="#"><img src="${ctx}/resources/images/write.png" /></a></li>
				<li class="timer-button"><a href="#"><img src="${ctx}/resources/images/count.png" /></a></li>
			</ul>
		</nav>
		
		<div class="timer">
			시간 입력 해줘!	 
			<input type="text" id="expireMin" style="width:30px;text-align:right">
			:
			<input type="text" id="expireSecond" style="width:30px;text-align:right">
			
			<button id="btnStartCountdown" onclick="startCountdown()">
			Start
			</button>
			<button id="btnStopCountdown" onclick="stopCountdown()">
			Stop
			</button>

			남은시간 : <label id="countText"></label>



		</div>
	</aside>
	
<script>
window.addEventListener("load", function(){
	var plusButton = document.querySelector(".plus-button");
	var writeButton = document.querySelector(".write-button");
	var timerButton = document.querySelector(".timer-button");
	var timer =document.querySelector(".timer");
	
	plusButton.onclick=function(){
		if(writeButton.classList.contains("show")==false){
			writeButton.classList.add("show");
			timerButton.classList.add("show");
		}
		else{
			writeButton.classList.remove("show");
			timerButton.classList.remove("show");
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

        countText += (day>0) ? (day + "일 ") : "";
        countText += (hour>0) ? hour + "시간 " : "";
        countText += min + "분 ";
        countText += sec + "초";
    }

    if (expireSec<=0) {
        countText = "종료";

        // 종료 후에 필요한 로직 구현
    }

    document.getElementById('countText').innerHTML = countText;

    if (expireSec>0) {
    	autoExecTimer = setTimeout("countdown(remainSec)", cycle*1000);
    }
}

function startCountdown() {
	var expireMin =  document.getElementById('expireMin').value;
	var expireSecond =  document.getElementById('expireSecond').value;
	var expireSec;
	
	if (expireMin == "" && expireSecond=="") {
		alert("실행예약시간을 분이나 초로 입력하십시오.");
		return;
	}
	
	expireSec=(expireMin*60)+expireSecond;
	countdown(expireSec);
}



function stopCountdown() {
	clearTimeout(autoExecTimer);
	document.getElementById('countText').innerHTML = '';
}



</script>
