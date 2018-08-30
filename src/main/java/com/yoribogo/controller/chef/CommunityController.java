package com.yoribogo.controller.chef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityComment;
import com.yoribogo.entity.CommunityContents;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;
import com.yoribogo.model.Editor;
import com.yoribogo.service.MemberService;
import com.yoribogo.service.chef.CommunityService;
import com.yoribogo.service.chef.RecipeService;

@Controller("ChefCommunityController")
@RequestMapping("/chef/community/")
public class CommunityController {
    
	@Autowired
	private CommunityService service;
	
	@Autowired
	private MemberService mservice;
	  
//----------------------------------- list --------------------------------------------------
      @RequestMapping("list")
      public String list(@RequestParam(value="p", defaultValue="1")Integer page,
    		  			 Model model) {
    	 
    	 List<Community> list = service.getCommunity();
    	 model.addAttribute("communityList", list);

         return "chef.community.list";
         
      }
    //편집기 content 겟
      @ResponseBody
      @RequestMapping("/ajax-editorContents-list")
    		public String editorContentsList(){
    			
    			List<Community> community = service.getCommunity();
    			
    			Gson gson = new Gson();
    			String json = gson.toJson(community);
    			//프론트로 보내어 ajax로 community.content[i] 루프 돌리자.
    			return json;  
    		}
      
    //편집기 listId content 겟  
      @ResponseBody
      @RequestMapping("{id}/ajax-editorContent-list")
    		public String editorContentList(
    				@RequestParam("id") Integer listId){
    			
    			Community community = service.get(listId);
    			
    			Gson gson = new Gson();
    			String json = gson.toJson(community);
    			System.out.println("json : "+json);
    			//프론트로 보내어 more클릭 이벤트 안에서 데이터 뽑아넣자.
    			return json;  
    		}
      
    //댓글 겟
      @ResponseBody
      @RequestMapping("{id}/ajax-comment-list")
    		public String ajaxList(
    					@PathVariable("id") Integer listId){
    			
    			List<CommunityComment> comments = service.getComment(listId);
    			
    			System.out.println("comments : "+comments);
    			Gson gson = new Gson();
    			String json = gson.toJson(comments);
    			System.out.println("json : "+json);
    			return json;  
    		}
    		
    	//댓글 포스트 
    	@PostMapping("{id}/comment/reg")
    	@ResponseBody //ajax로 결과값을 보여주는 형식을 사용하겠다. 모델도 빼자
    	public String commentReg(CommunityComment comment
    											, @PathVariable("id") Integer listId
    											, Principal principal){
    		
    			System.out.println("받아왔는가?"+comment.getContent());
    			
    			String memberId = principal.getName();
    			  
    			//댓글 프로필 사진 DB에 업로드
    			Member member = mservice.get(memberId);
    			
    			System.out.println("member : " + member);
    			//CommunityCommentView와 DB View를 만들어서 hb 대입할 것. 
    			comment.setProfile(member.getPhoto()); 
    			comment.setMemberId(memberId);
    			comment.setCommunityId(listId);
    			
    			System.out.println("comment : "+comment);
				
    			int result =  service.addComment(comment);
    			return String.valueOf(result); //문자열에 대한 원시데이터형을 리턴
    			
    		}

      @RequestMapping(value="reg", method=RequestMethod.GET)
      public String reg(Model model, Principal principal, Member member) {
    	
    	 String memberId = principal.getName();
    	 Member regInfo = mservice.get(memberId);
    	 model.addAttribute("member", regInfo); 
         return "chef.community.reg";
         
      }
      
      
      @RequestMapping(value="reg", method=RequestMethod.POST)
      public String insert(MultipartFile file[], 
    		  			   Principal principal, 
    		  			   Community community,
    		  			   HttpServletRequest request) {
    	  //memberId 담기
    	  String memberId = principal.getName();
    	  Member member = mservice.get(memberId);
    	  community.setMemberId(memberId);
    	  community.setMemberPhoto(member.getPhoto());
  
  	  String content = community.getContent();
  	  community.setContent(content);
  	  
  	  service.insertCommunity(community); 

         return "redirect:../community/list";
         
      }
}
