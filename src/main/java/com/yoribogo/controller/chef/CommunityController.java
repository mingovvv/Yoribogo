package com.yoribogo.controller.chef;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yoribogo.service.CommunityService;

@Controller("ChefCommunityController")
@RequestMapping("/chef/community/")
public class CommunityController {
    
	@Autowired
	private CommunityService service;
	
//----------------------------------- list --------------------------------------------------
      @RequestMapping(value="list")
      public String list(Model model) {
    	  
         return "chef.community.list";
      }
      
}