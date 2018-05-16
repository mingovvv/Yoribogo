package com.yoribogo.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.Member;
import com.yoribogo.service.MemberService;



@Controller("memberController")
@RequestMapping("/member/")

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
      
     
     
     
     
     
     
     
     
     
	@PostMapping("join")
	public String join(MultipartFile file
									, Model model
									, Member member
									, HttpServletRequest request
									, HttpServletResponse response) throws IOException, ServletException{
		
	
		System.out.println(file);
		ServletContext ctx = request.getServletContext();
		System.out.println(ctx);
		String fpath = "/resources/profile/"+member.getId();
	    String path = ctx.getRealPath(fpath); //물리경로
	    
	    String folder = ctx.getRealPath("/resources/profile/");

	    
	    File filefolder = new File(folder);
	    if(!filefolder.exists())
	    	filefolder.mkdir();
	    
	    File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdir();
	    
	    System.out.println(path);
	    System.out.println(filepath);
	    
	    
		if(!file.isEmpty()) {
			try {
				String fname = file.getOriginalFilename();  
				System.out.println(fname);
				
				member.setPhoto(fpath+'/'+fname);
				
				InputStream fis = file.getInputStream();
				
				FileOutputStream fos = new FileOutputStream(path + File.separator + fname); //File.separator 구분자 / \ 윈도우는 \ 유닉스는 / 니깐 둘중 골라주는놈 파일.세퍼레이톨
				
				byte[] buf = new byte[1024]; //버퍼 만들기
				
				int size = 0;
				
				while((size = fis.read(buf,0,1024)) != -1)
						fos.write(buf,0,size);
				
				fis.read(buf, 0, 1024);
				
				fis.close();
				fos.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(member);
		
		
		//--
		String pwd = member.getPwd();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPwd = passwordEncoder.encode(pwd);
		member.setPwd(hashedPwd);
		//--
		
		service.insertMember(member);
		
		System.out.println(model);
		
		PrintWriter out = response.getWriter();
		out.println("<script>alert('회원가입이 완료되었습니다.'); location.href='login';</script>");
		
		return "index";

	}
	
	
}