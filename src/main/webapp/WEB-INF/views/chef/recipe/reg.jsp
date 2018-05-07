<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main">
	<form class="reg-form">
		<div class="reg-frame">
			<div>
			<span>요리제목</span>
			<input type="text" placeholder="ex)베이컨샌드위치 만들기" />
			</div>
			
			<div>
			<span>간단한 설명</span>
			<textarea name="" id="" class="" placeholder="레시피를 간단하게 소개해주세요 ex)문득 좋은 아이디어가 생각나서 창작요리를 해보았답니다~" style="resize: none;"></textarea>
			</div>
			
			<div>
			<span>분류</span>
			
			
			<select>
				<option>종류별</option>
				<option value="">한식</option>
				<option value="">일식</option>
				<option value="">중식</option>
				<option value="">양식</option>
				<option value="">기타</option>
			</select>
			<select>
				<option>상황별</option>
				<option value="">영양식</option>
				<option value="">일상</option>
				<option value="">간식</option>
				<option value="">야식</option>
				<option value="">안주</option>
				<option value="">다이어트</option>
				<option value="">반찬</option>
				<option value="">기타</option>
			</select>
			<select>
				<option>시간별</option>
				<option value="">15분 ↓</option>
				<option value="">30분 ↓</option>
				<option value="">1시간 ↓</option>
				<option value="">2시간 ↓</option>
				<option value="">2시간 ↑</option>
			</select>
			
			
			</div>
			
			<div>
				<img id="" src="http://recipe.ezmember.co.kr/img/pic_none4.gif" style="width: 270px; height: 250px; cursor:pointer">
			</div>
			
			<div class="add-ingredient">
				<span>재료</span>
				<div class="box">
					<input name="ingredient1" type="text" placeholder="ex)돼지고기" />
					<img class="btn-cancel" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
				
				</div>
				<input type="button" value="추가" />
			</div>
			
			<div class="recipe-order">
				<span>요리순서</span>
				<p><b style="font-size: 25px;">step 1</b></p>
				<img class="btn-cancel" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
				<textarea name="" id="" class=" " placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." style="resize: none;"></textarea>
				<img id="" src="http://recipe.ezmember.co.kr/img/pic_none2.gif" style="width: 270px; height: 250px; cursor:pointer">
				<div class="recipe-box">
				
				</div>
				<input type="button" value="추가" />
			</div>
			
			<div>
				<span>요리꿀팁</span>
				<textarea name="" id="" class=" " placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." style="resize: none;"></textarea>
			</div>
		</div>
		
		<div class="button-container">
			<input class="btn btn-ok" type="button" value="글쓰기" />
			<input class="btn btn-cancel" type="button" value="취소하기" />
		</div>
	
	</form>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
$(function(){
	var addIngredientButton = $(".add-ingredient input[type=button]");
	var box = $(".add-ingredient .box");
	
	var addRecipeOrderButton = $(".recipe-order input[type=button]");
	var recipeBox = $(".recipe-order .recipe-box");
	var step = $(".recipe-order p b").text()
	
	var deleteButton = $(".btn-cancel");
	
	
	addIngredientButton.click(function(){ 
		$("<input name=\"ingredient1\" type=\"text\" placeholder=\"ex)돼지고기\" />").appendTo(box);
		$("<img class=\"btn-cancel\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\">").appendTo(box);
		
	});
	
	var n=1;
	addRecipeOrderButton.click(function(){
		n++;
		$("<p><b style=\"font-size: 25px;\">step "+n+"</b></p>").appendTo(recipeBox);
		$("<img class=\"btn-cancel\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\">").appendTo(recipeBox);
		$("<textarea name= id= class= placeholder=예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요. style=resize: none></textarea>").css("width","270px").css("height","100px").appendTo(recipeBox);
		$("<img src=http://recipe.ezmember.co.kr/img/pic_none2.gif>").css("width","270px").css("heigth","250px").appendTo(recipeBox);
	});
	
	deleteButton.click(function(){
		$(box).children().remove();
	})
	
});
































</script>