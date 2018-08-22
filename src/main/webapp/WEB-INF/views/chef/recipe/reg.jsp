<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<main class="main reg-main">
	<form method="post" class="reg-form" enctype="multipart/form-data">
		<div class="reg-frame">
			<div>
			<span>요리제목</span>
			<input type="text" name="title" required="required" placeholder="&nbsp;ex)베이컨샌드위치 만들기" />
			</div>
			
			<div>
			<span>간단한 설명</span>
			<textarea required name="description" required="required" placeholder="&nbsp;레시피를 간단하게 소개해주세요 &#13;&#10;&#13;&#10;ex)문득 좋은 아이디어가 생각나서 창작요리를 해보았답니다~" style="resize: none;"></textarea>
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
  				   

				<img id="photo_" name="representativeImage" src="http://recipe.ezmember.co.kr/img/pic_none4.gif">
  				 <input class="upload-name" value="파일선택" disabled="disabled"> 
  				 <label for=file_>업로드</label> 
  				 <input name="file" type="file" id="file_" class="upload-hidden" onchange="document.getElementById('photo_').src = window.URL.createObjectURL(this.files[0])"> 
			
			</div>
			
			   
			<div class="add-ingredient">
				<span>재료</span><div class="ingre-ex">* 재료이름만 간단하게 적어주세요 :)</div>
				<div class="box">
					<input id="ingredient_1" name="fname" type="text" placeholder="&nbsp;&nbsp;ex)돼지고기" onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"/>
					<img id="ingrdeient_del_1" class="btn-cancel" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
				</div>
				
				<input class="ingadd" type="button" value="재료추가" />
			</div>
			 
			<div class="recipe-order">  
				<span>요리순서</span> 
				<div id="noplz">
					<p>
						<b class="stepCount" style="font-size: 25px;">step 1</b>
					</p>
					<img class="btn-cancel" name="step-image-1" src="${ctx}/resources/images/ic_cancel_black_24dp_1x.png">
					
					
					<textarea required name="content"  placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." style="resize: none;"></textarea>
					
					
					<div class="filebox">
	
					<img class="step-image" id="photo_0" src="http://recipe.ezmember.co.kr/img/pic_none2.gif">
	  				 <input class="upload-name" value="파일선택" disabled="disabled"> 
	  				 <label for="ex_filename1">업로드</label> 
	  				 <input name="file" type="file" id="ex_filename1" class="upload-hidden" onchange="document.getElementById('photo_0').src = window.URL.createObjectURL(this.files[0])"> 
				
					</div>
				</div>
				
				<input class="orderadd" type="button" value="Step 추가" style="margin-top: 30px;"/>
			</div>
			
			<div>
				<span>요리꿀팁</span>
				<textarea name="ggulTip" id="" class=" " placeholder="예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요." style="resize: none;"></textarea>
			</div>
		</div>
		
		<div class="button-container">
			<input id="submit" class="btn btn-ok" type="submit" value="글쓰기" />
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
		
		$("	<div class=\"box\"><input id=\"ingredient_"+n+"\" name=\"fname\" type=\"text\" placeholder=\"&nbsp;&nbsp;ex)돼지고기\" onkeyup=\"noSpaceForm(this);\" onchange=\"noSpaceForm(this);\"/><img id=\"ingrdeient_del_"+n+"\" class=\"btn-cancel\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\"></div>	").insertBefore($(".ingadd"));
	
		
	});
	
	var n=1;
	var stepCount=$(".stepCount").text();
	addRecipeOrderButton.click(function(){
		/* n++; */
		var m=parseInt($(".stepCount").last().text().replace(/[^0-9]/gi,""))+1;
		
		if(isNaN(m)==true)
			m=1;
		$("	<div id=\"noplz\"><p><b class=\"stepCount\" style=\"font-size: 25px;\">Step "+m+"</b></p><img class=\"btn-cancel\" name=\"step-image-"+m+"\" src=\"${ctx}/resources/images/ic_cancel_black_24dp_1x.png\"><textarea required name=\"content\"  placeholder=\"예) 소고기는 기름기를 떼어내고 적당한 크기로 썰어주세요.\" style=\"resize: none;\"></textarea><div class=\"filebox\"><img class=\"step-image\" id=\"photo_"+m+"\" src=\"http://recipe.ezmember.co.kr/img/pic_none2.gif\"><input class=\"upload-name\" value=\"파일선택\" disabled=\"disabled\"> <label for=\"ex_filename"+m+"\">업로드</label> <input name=\"file\" type=\"file\" id=\"ex_filename"+m+"\" class=\"upload-hidden\" onchange=\"document.getElementById('photo_"+m+"').src = window.URL.createObjectURL(this.files[0])\"> </div></div> ").insertBefore($(".orderadd"))
		
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
	
	
	
});

	function noSpaceForm(obj) { // 공백사용못하게
	    var str_space = /\s/;  // 공백체크
	    if(str_space.exec(obj.value)) { //공백 체크
	        alert("해당 항목에는 공백을 사용할수 없습니다. \n공백은 자동적으로 제거 됩니다. :)");
	        obj.focus();
	        obj.value = obj.value.replace(' ',''); // 공백제거
	        return false;
	    }
	 // onkeyup="noSpaceForm(this);" onchange="noSpaceForm(this);"
	}

</script>
	
<script type="text/javascript">
$(document).ready(function() {
    $('#submit').bind("click",function() 
    { 
        var imgVal = $('#file_').val(); 
        if(imgVal=='') 
        { 
            alert("대표사진을 추가해주세요 :)"); 
            return false; 
        } 

 
    }); 
});
</script> 		
<script>

/* alert($("input[name=file]").length); */

/* for(var i = 0; i<$("input[name=file]").length; i++){ */

//해결할것
/* function readURL(input) {
    
    if (input.files && input.files[0]) {
        var reader = new FileReader();
       
        reader.onload = function (e) {
            $("#photo0").attr('src', e.target.result);
        }
 
        reader.readAsDataURL(input.files[0]);
    }    
}
 
$("#file0").change(function(){
    readURL(this);
});  */


/* 
} */

/* $(document).ready(
	    function() {
	        // 태그에 onchange를 부여한다.
	        $('#file').change(function() {
	                addPreview($(this)); //preview form 추가하기
	        });
	    });
	 
	    // image preview 기능 구현
	    // input = file object[]
	    function addPreview(input) {
	        if (input[0].files) {
	            //파일 선택이 여러개였을 시의 대응
	            for (var fileIndex = 0 ; fileIndex < input[0].files.length ; fileIndex++) {
	                var file = input[0].files[fileIndex];
	                var reader = new FileReader();
	 
	                reader.onload = function (img) {
	                    //div id="preview" 내에 동적코드추가.
	                    //이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
	                    $("#photo").attr('src', img.target.result);
	                };
	                
	                reader.readAsDataURL(file);
	            }
	        } else alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
	    }

 */
 

</script>
