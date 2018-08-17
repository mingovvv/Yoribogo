<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main reg-main">
	<form method="post" class="reg-form" enctype="multipart/form-data">
		<div class="reg-frame edit">
			<div>
			<span>제목</span>
			<input type="text" name="title" required="required" value="${recipe.title}"/>
			</div>
			
			<div>
			<span>간단한 설명</span>
			<textarea required name="description" style="resize: none;" >${recipe.description}</textarea>
			</div> 
			
			<div>
			<span>분류</span>
			
			
			<select name="sortNational">
				<option>종류별</option>
				<option value="한식">한식</option>
				<option value="일식">일식</option>
				<option value="중식">중식</option>
				<option value="양식">양식</option>
				<option value="기타">기타</option>
			</select>
			<select name="sortSituation">
				<option>상황별</option>
				<option value="영양식">영양식</option>
				<option value="일상">일상</option>
				<option value="간식">간식</option>
				<option value="야식">야식</option>
				<option value="안주">안주</option>
				<option value="다이어트">다이어트</option>
				<option value="반찬">반찬</option>
				<option value="기타">기타</option>
			</select>
			<select name="sortTime">
				<option>시간별</option>
				<option  value="15분 ↓">15분 ↓</option>
				<option  value="30분 ↓">30분 ↓</option>
				<option  value="1시간 ↓">1시간 ↓</option>
				<option  value="2시간 ↓">2시간 ↓</option>
				<option  value="2시간 ↑">2시간 ↑</option>
			</select>
			
			
			</div>
			
			<div class="filebox">

				<img id="photo_" name="representativeImage" src="${ctx}${recipe.representativeImage}">
  				 <input class="upload-name" value="파일선택" disabled="disabled"> 
  				 <label for=file_>업로드</label> 
  				 <input readonly value="444444444444444444444" name="file" type="file" id="file_" class="upload-hidden" onchange="document.getElementById('photo_').src = window.URL.createObjectURL(this.files[0])"> 
			
			</div>
			
			   
			<div class="add-ingredient">
				<span>재료</span><div class="ingre-ex">* 재료이름만 간단하게 적어주세요 :)</div>
					<c:forEach var="ingredient" items="${ingredient}">
						<div class="box">
							<input id="ingredient_1" name="fname" type="text" value="${ingredient.fname}" onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"/>
							<img id="ingrdeient_del_1" class="btn-cancel" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
						</div>
					</c:forEach>
				
				<input class="ingadd editv" type="button" value="재료추가" />
			</div>
			
			<div class="recipe-order">
				<span>요리순서</span>
				<c:forEach var="foodOrder" items="${foodOrder}" varStatus="status">
					<div id="noplz">
						<p>
							<b class="stepCount" style="font-size: 25px;">step ${foodOrder.chapter}</b>
						</p>
						<img class="btn-cancel" name="step-image-1" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
						
						
						<textarea required name="content"  placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." style="resize: none;">${foodOrder.content}</textarea>
						
						
						<div class="filebox">
						<c:if test="${foodOrder.image=='null'}">
						</c:if>
						<c:if test="${foodOrder.image!='null'}">
						<img class="step-image" id="photo_${status.count-1}" src="${ctx}${foodOrder.image}">
						</c:if>
		  				 <input class="upload-name" value="파일선택" disabled="disabled"> 
		  				 <label for="ex_filename${status.count}">업로드</label> 
		  				 <input name="file" type="file" id="ex_filename${status.count}" class="upload-hidden" onchange="document.getElementById('photo_${status.count-1}').src = window.URL.createObjectURL(this.files[0])"> 
					
						</div>
					</div>
				</c:forEach>
				
				<input class="orderadd editv" type="button" value="Step 추가" style="margin-top: 30px;"/>
			</div>
			
			<div>
				<span>요리꿀팁</span>
				<textarea name="ggulTip" style="resize: none;">${recipe.ggulTip}</textarea>
			</div>
		</div>
		
		<div class="button-container">
			<input id="submit" class="btn btn-ok" type="submit" value="수정하기" />
			<input class="btn btn-cancel" type="button" value="취소하기" />
		</div>
	
	
	</form>
</main>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	var addIngredientButton = $(".add-ingredient input[type=button]");
	var box = $(".add-ingredient .box");
	
	var addRecipeOrderButton = $(".recipe-order input[type=button]");
	var recipeBox = $(".recipe-order .recipe-box");
	var step = $(".recipe-order p b").text()
	
	var deleteButton = $(".btn-cancel");
	var Count =$(".stepCount").text().replace(/[^0-9]/gi,"");
	
	var i=1;
	addIngredientButton.click(function(){ 
		i++;
		
		$("	<div class=\"box\"><input id=\"ingredient_"+n+"\" name=\"fname\" type=\"text\" placeholder=\"&nbsp;&nbsp;ex)돼지고기\" 	onkeyup=\"noSpaceForm(this);\" onchange=\"noSpaceForm(this);	 \" /><img id=\"ingrdeient_del_"+n+"\" class=\"btn-cancel\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\"></div>	").insertBefore($(".ingadd"));
	
		
	});
	
	var n=1;
	var stepCount=$(".stepCount").text();
	addRecipeOrderButton.click(function(){
			
		var m=parseInt($(".stepCount").last().text().replace(/[^0-9]/gi,""))+1;
		
		if(isNaN(m)==true)
			m=1;
		
		$("	<div id=\"noplz\"><p><b class=\"stepCount\" style=\"font-size: 25px;\">step "+m+"</b></p><img class=\"btn-cancel\" name=\"step-image-"+m+"\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\"><textarea required name=\"content\"  placeholder=\"예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.\" style=\"resize: none;\"></textarea><div class=\"filebox\"><img class=\"step-image\" id=\"photo_"+m+"\" src=\"http://recipe.ezmember.co.kr/img/pic_none2.gif\"><input class=\"upload-name\" value=\"파일선택\" disabled=\"disabled\"> <label for=\"ex_filename"+m+"\">업로드</label> <input name=\"file\" type=\"file\" id=\"ex_filename"+m+"\" class=\"upload-hidden\" onchange=\"document.getElementById('photo_"+m+"').src = window.URL.createObjectURL(this.files[0])\"> </div></div> ").insertBefore($(".orderadd"))
		
	});
	
	
	$(document).on("click",".btn-cancel",function(){ //함수 바인딩
		
		
		$(this).siblings().remove();
		$(this).remove();
		
		for(var i=0; i<$(".stepCount").length;i++){
			$(".stepCount").eq(i).text("Step "+(i+1));
		}
		
	})
	   
	$(document).on("change",".upload-hidden",function(){
		if(window.FileReader){  
			var filename = $(this)[0].files[0].name; 
			} else {
				var filename = $(this).val().split('/').pop().split('\\').pop(); 
				} 
 		$(this).siblings('.upload-name').val(filename); 
	})
	
	$("select option[value='${recipe.sortNational}']").attr("selected", true);
	$("select option[value='${recipe.sortTime}']").attr("selected", true);
	$("select option[value='${recipe.sortSituation}']").attr("selected", true);

	  
	
});





function noSpaceForm(obj) { // 공백사용못하게
    var str_space = /\s/;  // 공백체크
    if(str_space.exec(obj.value)) { //공백 체크
        alert("해당 항목에는 공백을 사용할수 없습니다.\n공백은 자동적으로 제거 됩니다. :)");
        obj.focus();
        obj.value = obj.value.replace(' ',''); // 공백제거
        return false;
    }
 // onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
}


</script>
