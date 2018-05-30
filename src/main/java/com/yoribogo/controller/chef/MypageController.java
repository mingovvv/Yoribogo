package com.yoribogo.controller.chef;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;



@RequestMapping("/chef/mypage/")
@Controller("ChefMypageController")
public class MypageController {
	
	@GetMapping("entrance")//최신버전 get까지가능
	public String mypage() {
		
		return "chef.mypage.entrance";
	}
	
}