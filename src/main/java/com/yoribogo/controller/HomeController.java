package com.yoribogo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;

@Controller
@RequestMapping("/")


public class HomeController {

	
	@RequestMapping("index")
	public String index() {
		return "index";	
		
	}
	

}