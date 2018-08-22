package com.yoribogo.controller.chef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityContents;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.model.Editor;
import com.yoribogo.service.MemberService;
import com.yoribogo.service.chef.CommunityService;
import com.yoribogo.service.chef.RecipeService;

@Controller("ChefCommunityController")
@RequestMapping("/chef/community/")
public class CommunityController {
    
	@Autowired
	private CommunityService service;
	
	@Autowired
	private MemberService mservice;
	
	@Autowired
	private RecipeService rservice;
	
//----------------------------------- list --------------------------------------------------
      @RequestMapping("list")
      public String list(@RequestParam(value="p", defaultValue="1")Integer page,
    		  			 Model model,
    		  			 Principal principal) {
    	 String memberId = principal.getName();

    	/* Member member = mservice.getMember(memberId);
    	 model.addAttribute("member", member);*/
    	 
    	 /*List<Community> community = service.getCommunity();
    	 model.addAttribute("community", community);*/
    	/*List<Recipe> recipe = rservice.getRecipe();
    	 
    	 model.addAttribute("recipe", recipe);*/
    	 
         return "chef.community.list";
         
      }
      
      /*------------------------편집기 이용한 싱글이미지업로더 -------------------------------*/
      
      
      
      @RequestMapping(value="reg", method=RequestMethod.GET)
      public String reg(Model model) {
    	
    	 //이전 페이지에서 memberId를 받아와야 한다.
    	 
    	  
         return "chef.community.reg";
         
      }
      
      
      @RequestMapping(value="reg", method=RequestMethod.POST)
      public String insert(MultipartFile file[], 
    		  			   Principal principal, 
    		  			   Community community,
    		  			   /*CommunityContents subContents,*/
    		  			   HttpServletRequest request) {
    	  //memberId 담기
    	  String memberId = principal.getName();
    	  
    	  community.setMemberId(memberId);
  /*-----------------------image 담기------------------------------*/
    	  ServletContext ctx = request.getServletContext();
  		
  		  String fpath = "/resources/communityImage/"+memberId;

   		  String path = ctx.getRealPath(fpath);
  		
  		
  		File filepath = new File(path);
  	    if(!filepath.exists())
  	    	filepath.mkdirs();
  	    
  	    if(!file[0].isEmpty()) {
  			try {
  				String fname = file[0].getOriginalFilename();  
  				
  				community.setImage(fpath+'/'+fname);
  				
  				InputStream fis = file[0].getInputStream();
  				
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
  	  /*----------------content 담기-----------------*/  
  	  String content = community.getContent();
  	  community.setContent(content);
  	    
  	  service.insertCommunity(community); 
  	   
  	  /*-----------subImage 담기 나중구현----------------------*/
  	  /*String[] array = community.getContent().split(",");
		
		for(int i=1;i<file.length;i++) {
			
			String fpath2 = "/resources/communitySubImage/"+memberId+"/"+i;
		    String path2 = ctx.getRealPath(fpath2);
		    
		    File filepath2 = new File(path2);
		    if(!filepath2.exists())
		    	filepath2.mkdirs();
			
			if(!file[i].isEmpty()) {
				try {
					String fname = file[i].getOriginalFilename();  
					
					community.setImage(fpath2+'/'+fname);
					
					InputStream fis = file[i].getInputStream();
					
					FileOutputStream fos = new FileOutputStream(path2 + File.separator + fname); //File.separator 구분자 / \ 윈도우는 \ 유닉스는 / 니깐 둘중 골라주는놈 파일.세퍼레이톨
					
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
			//자동으로 id가 생성되는 것인가??로직상 위의 커뮤니티가 생성 된 후에 실행되기 때문에 문제없다.
			
			subContents.setSubContent(array[i-1]);
			int communityId = community.getId();	
  	  		subContents.setCommunityId(communityId);
  	  		subContents.setIndex(0);
			service.insertSubContents(subContents);
	  		
	  		-subcontent 담기-*/
  	  	
		
         return "redirect:../community/list";
         
      }
}
