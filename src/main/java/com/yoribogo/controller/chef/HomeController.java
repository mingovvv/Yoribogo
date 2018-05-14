package com.yoribogo.controller.chef;

import java.security.Principal;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;



@RequestMapping("/chef/")
@Controller("ChefHomeController") /*식별자 한쪽만 / 식별 가능하면 됨 / 노트 컨트롤러가 두개가 존재하기에 생기는 문제*/
public class HomeController {
	
/*	@Autowired
	private NoteService service;//어나니머스들을 위한 노트서비스가 아님 이것도 2개인거야
*/	
	@Autowired
	private MemberService service;
	
	
	@GetMapping("index")//최신버전 get까지가능
	public String index(Integer page, Model model,Principal principal) {
		
		/*List<Note> note =service.getNoteList(page);
		model.addAttribute("notes" ,note);*/
		
		String mId =principal.getName();
		Member member = service.getMemberInfo(mId);
		
		System.out.println("아이디 = " + mId);
		System.out.println(member);
		
		model.addAttribute("member",member);
		
		return "chef.index";
	}
	
	
	/*	@GetMapping("pro")
	public String aside(Principal principal, Model model) {
		
		String mId =principal.getName();
		Member member = service.getMemberInfo(mId);
		
		System.out.println("아이디 = " + mId);
		System.out.println(member);
		
		model.addAttribute("member",member);
		
		return "index";	
		
	}*/
	
}