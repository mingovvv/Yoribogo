package com.yoribogo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoribogo.entity.Community;
import com.yoribogo.service.CommunityService;

@Controller("CommunityController")
@RequestMapping("/community/")
public class CommunityController {
    
	@Autowired
	private CommunityService service;
	
//----------------------------------- list --------------------------------------------------
      @RequestMapping("list")
      public String list(Model model) {
    	 
    	
         return "community.list";
      }
    
      
//-------------Ajax 댓글리스트 컨트롤러--------------------
      /*@ResponseBody
      @RequestMapping(value="list/commentList", method=RequestMethod.POST)
      public String commentList(@RequestParam("listId")String memberId, Model model) {
     	 
     	  String result = "";
     	  Member data = service.getMemberInfo(memberId);
     	  
           if(data!=null) 
         	 result="exist";
           else
         	 result="none";
           
           return result;
      }*/
      
}