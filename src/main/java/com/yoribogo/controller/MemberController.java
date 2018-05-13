package com.yoribogo.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;
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
      
      //@PostMapping("join") 이렇게 써두 됨
     
	@PostMapping("join")
	@ResponseBody
	public String join(MultipartFile file
									, Member member
									, HttpServletRequest request
									, HttpServletResponse response) throws IOException, ServletException{
		
	
		System.out.println(file);
		ServletContext ctx = request.getServletContext();
		System.out.println(ctx);
	    String path = ctx.getRealPath("/resources/profile/"+member.getId()); //물리경로
	    File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdir();
	    System.out.println(path);
	    System.out.println(filepath);
	    
	    
		if(!file.isEmpty()) {
			try {
				String fname = file.getOriginalFilename();  
				System.out.println(fname);
				member.setPhoto(path+"/"+fname);
				
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
		
		//String memberId = member.getId();
		service.insertMember(member);
		/*service.insertMemberRole(memberRole);*/
		/*service.insertMemberRole(member, memberRole);*/
		/*service.insertMemberRole(memberRole);*/
		return pwd + ":" + hashedPwd;

	}
}