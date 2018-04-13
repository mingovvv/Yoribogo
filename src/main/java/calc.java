public class calc {
	public static void main(String args[]) {
		int a = 60;
		int b = 86400;
		System.out.println(61/60);
	}
}




<div class="timer">
시간 입력 해줘!	 
<input type="text" id="expireMin" style="width:30px;text-align:right">
:
<input type="text" id="expiresecond" style="width:30px;text-align:right">

<button id="btnStartCountdown" onclick="startCountdown()">
Start
</button>
<button id="btnStopCountdown" onclick="stopCountdown()">
Stop
</button>

남은시간 : <label id="countText"></label>



</div>