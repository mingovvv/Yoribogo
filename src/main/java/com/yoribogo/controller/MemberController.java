package com.yoribogo.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;
import com.yoribogo.service.MemberService;



@Controller("memberController")
@RequestMapping("/member/")
@MultipartConfig
(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*100,
		maxRequestSize = 1024*1024*100*5
)
public class MemberController {
    
	@Autowired
	private MemberService service;
	
	//----------------------------------- 로그인 --------------------------------------------------
	
	
      @RequestMapping(value="login", method=RequestMethod.GET)
      public String login() {
         
         return "member.login";
      }
      
      
      
      

      
      
      
      
      //----------------------------------- 회원가입 --------------------------------------------------
      
     @RequestMapping(value="join", method=RequestMethod.GET)
      public String join() {
        
         return "member.join";
      } 
      
      //@PostMapping("join") 이렇게 써두 됨
     
	@PostMapping("join")
	@ResponseBody
	public String join(MultipartFile file, Member member, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		
		
		String pathURL = "/resources/profile";
		String pathSystem = request.getServletContext().getRealPath(pathURL);
		
		if(!((File) file).exists())
			((File) file).mkdir();
				
		Part part = request.getPart("profile");	
		InputStream is = part.getInputStream();
		String fname = part.getSubmittedFileName();

		byte[] buf = new byte[1024];
		
			if(fname.isEmpty())
			fname="profile.png";
		
		FileOutputStream fos = new FileOutputStream(pathSystem+File.separator+fname);
				
		int size=0;
		while((size = is.read(buf,0,1024)) != -1)
			fos.write(buf,0,size);

		is.close();
		fos.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println(member);
		
		
		//--
		String pwd = member.getPwd();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPwd = passwordEncoder.encode(pwd);
		member.setPwd(hashedPwd);
		//--
		
		
		//String memberId = member.getId();
		service.insertMember(member);
		/*service.insertMemberRole(memberRole);*/
		/*service.insertMemberRole(member, memberRole);*/
		/*service.insertMemberRole(memberRole);*/
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