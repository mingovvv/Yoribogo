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
	
//----------------------------------- list --------------------------------------------------
      @RequestMapping("list")
      public String list(@RequestParam(value="p", defaultValue="1")Integer page,
    		  			 Model model) {
    	 
    	 List<Community> list = service.getCommunity();

    	 model.addAttribute("communityList", list);
    	 
    	 //List<Commen>
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
}
