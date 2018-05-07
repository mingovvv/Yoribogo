package com.yoribogo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;



@Controller("memberController")
@RequestMapping("/member/")
public class MemberController {
    
	@Autowired
	private MemberService service;
	
      @RequestMapping(value="login", method=RequestMethod.GET)
      public String login() {
         
         return "member.login";
      }
      
      
      
      
      
      
      
      
      
      
      
     @RequestMapping(value="join", method=RequestMethod.GET)
      public String join() {
        
         return "member.join";
      } 
      
      //@PostMapping("join") 이렇게 써두 됨
     
	@PostMapping("join")
	@ResponseBody
	public String join(Member member) {

		System.out.println(member);
		String pwd = member.getPwd();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String hashedPwd = passwordEncoder.encode(pwd);
		member.setPwd(hashedPwd);

		service.insertMember(member);
		return pwd + ":" + hashedPwd;

	}
     

     /* 스프링이 제공하는걸 사용할거니깐 주석*/
   /*   @RequestMapping(value="login", method=RequestMethod.POST)
      public String login(String id, String pwd) {
         return "redirect:../index"; 
      }*/
      
 /*     @RequestMapping(value="join", method=RequestMethod.GET)
      public String join() {
        
         return "member.join";
      } 
      
      @RequestMapping(value="join", method=RequestMethod.POST)
      public String login(Member member) { //맴버컨트롤러 안에는 아이디 패스워드 등..
         
    	  int result = service.insertMember(member);
    	 
    	  return "redirect:../index"; 
      }*/
}