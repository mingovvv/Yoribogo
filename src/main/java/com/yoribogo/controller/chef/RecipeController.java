package com.yoribogo.controller.chef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;
import com.yoribogo.entity.RecipeLike;
import com.yoribogo.service.chef.RecipeService;

import antlr.StringUtils;

@Controller("ChefRecipeController")
@RequestMapping("/chef/recipe/")
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model, Principal principal) {
		
		String memberId = principal.getName();
		
		List<Recipe> recipe = service.getRecipe();
		model.addAttribute("recipe",recipe);
		
		System.out.println("recipe : "+recipe);
		
		List<RecipeLike> recipeLike = service.getRecipeLike(memberId);
		model.addAttribute("recipeLike",recipeLike);
		
		System.out.println("recipeLike : "+recipeLike);
		
		
		
		return "chef.recipe.list";
	}
	  
	
	
	@GetMapping("{id}")//경로 설정
	public String detail(@PathVariable("id") Integer id, Model model,
								@PathVariable("id") Integer recipeId,
								Principal principal,
								HttpServletRequest req,
								HttpServletResponse res) { //파라미터 말고 주소 url때문에
		
		String memberId = principal.getName();
		model.addAttribute("loginId",memberId);
		
		Recipe recipe = service.getRecipe(id);
		model.addAttribute("recipe",recipe);
		
		
		//글쓴이 프로필 사진 가져오기
		Member memberf= service.getMember(recipe.getMemberId());
		model.addAttribute("memberf", memberf);
		
		List<Ingredient> ingredient = service.getIngridient(recipeId);
		model.addAttribute("ingredient",ingredient);
		
		List<FoodOrder> foodOrder = service.getFoodOrder(recipeId);
		model.addAttribute("foodOrder",foodOrder);
		
		List<RecipeLike> recipeLike = service.getRecipeLike(memberId);
		model.addAttribute("recipeLike",recipeLike);
		
		//--------------------------------------------------------------------------------------
		//좋아요 숫자(디테일페이지)
		int likeCount = service.getLikeCount(recipeId);
		model.addAttribute("likeCount",likeCount);
		
		//--------------------------------------------------------------------------------------
		//쿠키사용 조회수 확인하기
		 boolean isGet=false;
		 int readCount = 0;
		  Cookie[] cookies=req.getCookies();
		  System.out.println("쿠키의 갯수 : "+cookies.length);
		  if(cookies!=null){   
		   for(Cookie c: cookies){//    
			   System.out.println("존재하는 쿠키의 이름 : "+c.getName());
			   System.out.println("존재하는 쿠키의 값 : "+c.getValue());
		    //id 쿠키가 있는 경우
		    if(c.getName().equals(String.valueOf(id))){
		    	System.out.println("쿠키가 존재합니다");
		    	System.out.println("해당게시물의 쿠키의 이름 : "+c.getName());
		    	System.out.println("해당게시물의 쿠키의 값 : "+c.getValue());
		    	
		     isGet=true; 
		    }
		   }
		   
		   // id 쿠키가 없는 경우
		   if(!isGet) {
			   System.out.println("쿠키가 없습니다. 생성하겠습니다");
			readCount = service.getReadCount(recipeId); // 조회수 1 올리는 로직
		    Cookie c1 = new Cookie(String.valueOf(id), String.valueOf(id)); 
		    c1.setMaxAge(1*24*60*60);//하루저장
		    res.addCookie(c1);    
		   }
		  }
		
		  model.addAttribute("readCount",readCount);
		  
		//--------------------------------------------------------------------------------------
		//댓글 갯수
		
		  int commentCount = service.getCommentCount(recipeId);
		  model.addAttribute("commentCount",commentCount);
		  
				
		return "chef.recipe.detail";
		
	}
	
	
	
	//댓글 작업-------------------------------------------------------------------------------
		
		//댓글 겟
		@ResponseBody
		@RequestMapping("{id}/ajax-comment-list")
		public String ajaxList(
					@PathVariable("id") Integer recipeId,
				  	@RequestParam(value="p", defaultValue="1") Integer page){
			
			List<RecipeComment> comments = service.getRecipeCommentListByNote(page, recipeId);
			
			System.out.println("comments : "+comments);
			Gson gson = new Gson();
			String json = gson.toJson(comments);
			System.out.println("json : "+json);
			return json;  
		}   
		
		//댓글 포스트 
		@PostMapping("{id}/comment/reg")
		@ResponseBody //ajax로 결과값을 보여주는 형식을 사용하겠다. 모델도 빼자
		public String commentReg(RecipeComment comment
												, @PathVariable("id") Integer recipeId
												,Principal principal){
			
			
			String memberId = principal.getName();
			
			//댓글 프로필 사진 DB에 업로드
			Member memberRep = service.getMember(memberId);
			
			System.out.println("memberRep : " + memberRep);
			
			comment.setProfile(memberRep.getPhoto()); 
			comment.setMemberId(memberId);
			comment.setRecipeId(recipeId);
			
			System.out.println("comment : "+comment);
				
			
			int result =  service.addComment(comment);
			return String.valueOf(result); //문자열에 대한 원시데이터형을 리턴
			
		}
	
	
	
	
	
	
		//좋아요 ajax
		@ResponseBody
		@PostMapping("{id}/like")
		public String like(@PathVariable("id") Integer recipeId, Principal principal) {
	
			String memberId = principal.getName();
			
			service.setRecipeLike(recipeId, memberId);
			
			List<RecipeLike> recipeLike = service.getRecipeLike(memberId);
			
			Gson gson = new Gson();
			String json = gson.toJson(recipeLike);
			
			System.out.println("like json 는 ? :"+json);
			return json;
	
		}
	
	
	
	
	
	
	
	
	

	@GetMapping("reg")
	public String reg() {
		
		
		
		return "chef.recipe.reg";
	}
	
	@PostMapping("reg")
	public String reg(FoodOrder foodOrder, MultipartFile file[], Recipe recipe, Principal principal, Ingredient ingredient, HttpServletRequest request) {
		
		System.out.println("recipe 는 "+recipe);
		System.out.println("foodOrder 는 "+foodOrder);
		System.out.println("ingredient 는 "+ingredient);
		
		String memberId = principal.getName();
		System.out.println("당신의 로그인 아이디 = "+memberId);
		
		recipe.setMemberId(memberId);
		
		
		
		
		System.out.println("레시피 아이디" + recipe.getId() );
		
		
		
		
		ServletContext ctx = request.getServletContext();
		
		String fpath = "/resources/representativeImage/"+memberId;
		System.out.println("레시피 아이디" + recipe.getId() );
		String path = ctx.getRealPath(fpath);
		
		
		File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdirs();
	    
	    
	    
		
	    System.out.println("파일1"+file[0]);
		
	    
	    
	    if(!file[0].isEmpty()) {
			try {
				System.out.println("동작가능?");
				String fname = file[0].getOriginalFilename();  
				System.out.println(fname);
				
				recipe.setRepresentativeImage(fpath+'/'+fname);
				
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
	    
	    service.insertRecipe(recipe);
		
	    String[] array= ingredient.getFname().split(",");
		for(int i=0; i < array.length;i++) {
			System.out.println(i+"번째 재료는 ? =" +array[i]);
			
			ingredient.setFname(array[i]);
			int recipeId=recipe.getId();
			ingredient.setRecipeId(recipeId);
			ingredient.setmemberId(memberId);
			service.insertingredient(ingredient);
		}
	  //----------------------------------------------------------------

	  		
		String[] array2 = foodOrder.getContent().split(",");
	  		
	  		for(int i=1;i<file.length;i++) {
	  			
	  			
	  			String fpath2 = "/resources/orderImage/"+memberId+"/"+i;
	  		    String path2 = ctx.getRealPath(fpath2);
	  		    
	  		    File filepath2 = new File(path2);
	  		    if(!filepath2.exists())
	  		    	filepath2.mkdirs();
	  			
	  			
	  			
	  		System.out.println("input file 갯수 : " + file.length);
	  			
	  			if(!file[i].isEmpty()) {
	  				try {
	  					String fname = file[i].getOriginalFilename();  
	  					System.out.println(fname);
	  					
	  					foodOrder.setImage(fpath2+'/'+fname);
	  					
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
	  			
	  			int recipeId=recipe.getId();
		  		foodOrder.setContent(array2[i-1]);
		  		foodOrder.setChapter(i);
		  		foodOrder.setRecipeId(recipeId);
		  		service.insertFoodOrder(foodOrder);
	  			
	  			
	  		}
	  		//----------------------------------------------------------------
	  		
	  		
	  		
		return "redirect:../recipe/list";
		
	}

}
