package com.yoribogo.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;
import com.yoribogo.service.RecipeService;
import com.yoribogo.service.chef.CommunityService;


@Controller("CommunityController")
@RequestMapping("/community/")
public class CommunityController {
    
	@Autowired
	private CommunityService service;
	
	@Autowired
	private MemberService mservice;
	
	@Autowired
	private RecipeService rservice;
	
//----------------------------------- list --------------------------------------------------
      @RequestMapping("list")
      public String list(@RequestParam(value="p", defaultValue="1")Integer page,
    		  			 Model model) {
    	 
    	 List<Community> list = service.getCommunity();

    	 model.addAttribute("communityList", list);
    	 
    	 //List<Commen>
         return "chef.community.list";
         
      }
      
      
      @RequestMapping("list/commentList")
      @ResponseBody
      public String commentList(@RequestParam("listId") Integer listId) {
    	 
    	List<CommunityComment> commentList = service.getComment(listId);
    	 
    	 Gson gson = new Gson();
    	 String json = gson.toJson(commentList);
    	 
    	 System.out.println(json);
         return json;
         
      }
    //댓글 겟
      @ResponseBody
      @RequestMapping("{id}/ajax-comment-list")
    		public String ajaxList(
    					@PathVariable("id") Integer listId){
    			
    			/*List<CommunityComment> comments = service.getComment(listId);
    			
    			System.out.println("comments : "+comments);
    			Gson gson = new Gson();
    			String json = gson.toJson(comments);
    			System.out.println("json : "+json);*/
    			return "1";  
    		}
    		
    		//댓글 포스트 
    		@PostMapping("{id}/comment/reg")
    		@ResponseBody //ajax로 결과값을 보여주는 형식을 사용하겠다. 모델도 빼자
    		public String commentReg(CommunityComment comment
    												, @PathVariable("id") Integer listId
    												,Principal principal){
    			
    			//System.out.println("여기서 이미 있냐?"+comment.getContent());
    			
    			String memberId = principal.getName();
    			
    			//댓글 프로필 사진 DB에 업로드
    			Member member = mservice.getMember(memberId);
    			
    			System.out.println("memberRep : " + member);
    			//CommunityCommentView와 DB View를 만들어서 hb 대입할 것. 
    			//comment.setProfile(member.getPhoto()); 
    			comment.setMemberId(memberId);
    			comment.setCommunityId(listId);
    			
    			System.out.println("comment : "+comment);
				
    			//int result =  service.addComment(comment);
    			return String.valueOf(1); //문자열에 대한 원시데이터형을 리턴
    			
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
