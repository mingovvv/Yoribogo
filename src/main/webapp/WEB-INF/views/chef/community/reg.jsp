<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<main class="main">
		<!-- 게시글 등록 폼 -->
		<form method="post" enctype="multipart/form-data">
		<section id="reg-section">
    
				<!-- 작성자 데이터 가져올 것. -->      
				<div class="reg-member-info">
					<div style="width:30%; display:flex; align-items: center; justify-content: center;">
						<div class="reg-member-img"></div>
					</div>
					<div class="reg-member-id"><div>memberId</div></div>
				</div>
				
				<div class="reg-content">
					<h1>image</h1>
					<div class="reg-content-img">
						<img id="photo"
							src="${ctx}/resources/images/profile.png"
							style="width: 100%; height: 100%; border: 1px solid #595959;  box-shadow: 0 4px 15px 0 rgba(0, 0, 0, 0.15);" />
					</div>
					<input id="file" style="border: none" type="file" name="file" class="inpt" > 
					<h2>title or 간단한멘트</h2>
					<div class="reg-content-text">
						<input class="inpt" name="content" type="text" style="height:100%; width:100%;"/>
					</div>
						<!-- 편집기 api사용(스마트 에디터) -->	
					<h2>more detail</h2>			      
				        <textarea name="editor" id="editor" style="width: 100%; min-height: 200px; height:auto;"></textarea>     
				</div>    
		</div>
		</section>
		<!-- 등록/취소 버튼 -->    
		<div class="two-btn">    
			<div><button class="submit btn" type="submit" value="등록">등록</button></div>    
			<div><button class="cancel btn" type="button"  value="취소">  
				<a href="${ctx}/chef/community/list">취소</a>
				</button>
			</div>
		</div>    
		</form>
	</main> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
<script type="text/javascript" src="${ctx}/resources/editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">

$(function(){
    //전역변수    
    var obj = [];
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "editor",
        sSkinURI: "${ctx}/resources/editor/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부
            bUseToolbar : true,
            // 입력창 크기 조절바 사용 여부
            bUseVerticalResizer : true,
            // 모드 탭(Editor | HTML | TEXT) 사용 여부
            bUseModeChanger : true,
        }
    });
    //전송버튼
    $("#insertBoard").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $("#insertBoardFrm").submit();
    });
});
</script>

<script>
/* 등록버튼 클릭 시 등록하시겠습니까 보이게 할 것. */
</script>