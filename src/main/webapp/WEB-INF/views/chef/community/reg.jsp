<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

	<main class="main">
		<!-- 게시글 등록 폼 -->
		<form id ="form" method="post" action="${ctx}/chef/community/reg" enctype="multipart/form-data">
		<section id="reg-section">
    
				<!-- 작성자 데이터 가져올 것. -->      
				<div class="reg-member-info">
					<div style="width:30%; display:flex; align-items: center; justify-content: center;">
						<div class="reg-member-img">
							<c:if test="${member.photo !=''}">
								<img alt="" src="${ctx}${member.photo}" style="width:90px; height:90px; border-radius:100px;">
							</c:if>
							<c:if test="${member.photo ==''}">
								<img alt="" src="${ctx}/resources/images/chef.png" style="width:90px; height:90px; border-radius:100px;">
							</c:if>	    
						</div>    
					</div>    
					<div class="reg-member-id"><div>${member.nickname}</div></div>
				</div>
				
				<div class="reg-content">
					<!-- <h1>title or 간단한멘트</h1>
					<div class="reg-content-text">
						<input class="inpt" name="content" type="text" style="height:100%; width:100%;"/>
					</div> -->
						<!-- 편집기 api사용(스마트 에디터) -->			      
				        <textarea name="content" id="editor" style="width: 100%; min-height: 200px; height:auto;" placeholder="첫번째 사진과 200자의 글이 게시글에 보이게 됩니다."></textarea>     
				</div>          
		</div>
		</section>
		<!-- 등록/취소 버튼 -->    
		<div class="two-btn" style=" margin-top: 20px;">       
			<div><button id="insert" class="submit btn" type="submit" value="등록">등록</button></div>    
			<div><button class="cancel btn" type="button"  value="취소">  
				<a href="${ctx}/chef/community/list">취소</a>
				</button>
			</div>
		</div>    
		</form>
	</main> 

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
    
    $("#insert").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["editor"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        //$("#insert").submit();
    });
  //등록 전 유효성 검사
    $('#form').submit(function(){
    	
    	if($('#editor').val().length <= 4){
    		$('#editor').focus();
    		
    		return false;
    		
    	}else
    		return true;
    });
});
</script>

<script>
/* 등록버튼 클릭 시 등록하시겠습니까 보이게 할 것. */
</script>