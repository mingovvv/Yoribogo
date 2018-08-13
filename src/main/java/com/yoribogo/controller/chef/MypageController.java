package com.yoribogo.controller.chef;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeLike;
import com.yoribogo.service.MemberService;
import com.yoribogo.service.chef.RecipeService;




@RequestMapping("/chef/mypage/")
@Controller("ChefMypageController")
public class MypageController {
	
	@Autowired
	private RecipeService service;
	
	@Autowired
	private MemberService memberservice;
	
	
	@GetMapping("entrance")
	public String mypage(Model model,
									Principal principal) {
		
		String memberId = principal.getName();
		
		Member member = service.getMember(memberId);
		model.addAttribute("member",member);
		
		List<Recipe> recipe = service.getRecipe(memberId);
		model.addAttribute("recipe",recipe);
		
		System.out.println("잘받아왔니?"+recipe);
		
		List<RecipeLike> recipeLike = service.getRecipeLike(memberId);
		model.addAttribute("recipeLike",recipeLike);
		
		List<Recipe> likeRecipe = service.getLikeRecipe(memberId);
		model.addAttribute("likeRecipe",likeRecipe);
		
		return "chef.mypage.entrance";
		
		
	}
	
	@PostMapping("entrance")//개인 정보수정
	public String mypage(Member member,
									Principal principal,
									MultipartFile file,
									HttpServletRequest request,
									HttpServletResponse response,
									Model model) throws IOException {
		
		System.out.println("처음 받아온 회원 정보 : "+member);
		ServletContext ctx = request.getServletContext();
		
		String memberId = principal.getName();
		member.setId(memberId);
		
		
		String fpath = "/resources/profiles/"+memberId;
	    String path = ctx.getRealPath(fpath); //물리경로
	    
	    File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdirs();
	    System.out.println("path : "+path);
	    System.out.println("filepath : "+filepath);
	    
	    if(!file.isEmpty()) {
			try {
				String fname = file.getOriginalFilename();  
				System.out.println("fname : "+fname);
				
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
				
				e.printStackTrace();
			}
		}
		
		
		
		//--
		String pwd = member.getPwd();
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPwd = passwordEncoder.encode(pwd);
		member.setPwd(hashedPwd);
		//--
		
		System.out.println("비밀번호 / 프로필 수정된 회원 정보" + member);
		
		//업데이트를 하자
		memberservice.updateProfile(member);
		
		model.addAttribute("msg", "수정이 완료되었습니다 :)"); 
		model.addAttribute("url", "chef/mypage/entrance");
		
	    
		return "result";
		
	}
}