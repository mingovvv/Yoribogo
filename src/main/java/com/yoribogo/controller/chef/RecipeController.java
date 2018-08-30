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
import org.springframework.web.bind.annotation.PutMapping;
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
		
		model.addAttribute("checkDetail",1);
		
		
		
		return "chef.recipe.list";
	}
	  
	
	
	//date 순 정렬
	@GetMapping("list/date")
	@ResponseBody
	public String listDate(Principal principal){
		
		String memberId = principal.getName();
		List<Recipe> recipe = service.listDate(memberId);
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
	
	//인기 순 정렬
	@GetMapping("list/pop")
	@ResponseBody
	public String listPop(Principal principal){
		
		String memberId = principal.getName();
		List<Recipe> recipe = service.listPop(memberId);
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
	
	//랜덤 정렬
	@GetMapping("list/ran")
	@ResponseBody
	public String listRan(Principal principal){
		
		String memberId = principal.getName();
		List<Recipe> recipe = service.listRan(memberId);
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
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
		    c1.setMaxAge(60);//1분저장 (악의적 조회수 올리기 제한)
		    res.addCookie(c1);    
		   }
		  }
		
		  model.addAttribute("readCount",readCount);
		  
		//--------------------------------------------------------------------------------------
		//댓글 갯수
		
		  int commentCount = service.getCommentCount(recipeId);
		  model.addAttribute("commentCount",commentCount);
		  
		  
		  model.addAttribute("checkDetail",2);
				
		return "chef.recipe.detail";
		
	}
	
	
	
	
	//레시피 수정하기--------------------------------------------------------------------------------
	@GetMapping("{id}/edit")//경로 설정
	public String edit(@PathVariable("id") Integer id,
								Model model,
								Principal principal) {
		
		Recipe recipe = service.getRecipe(id);
		model.addAttribute("recipe",recipe);
		
		List<Ingredient> ingredient = service.getIngridient(id);
		model.addAttribute("ingredient",ingredient);
		
		List<FoodOrder> foodOrder = service.getFoodOrder(id);
		model.addAttribute("foodOrder",foodOrder);
		
		
		return "chef.recipe.edit";
	}
	

	
	
	@PostMapping("{id}/edit")
	public String edit(FoodOrder foodOrder,
								MultipartFile file[],
								Recipe recipe,
								Principal principal,
								Ingredient ingredient,
								HttpServletRequest request,
								@PathVariable("id") Integer recipeId){
		
		
		Recipe recipeImage = service.getRecipe(recipeId);
		
		
		System.out.println("recipe =edit= "+recipe);
		System.out.println("foodOrder =edit= "+foodOrder);
		System.out.println("ingredient =edit="+ingredient);
		
		String memberId = principal.getName();
		ServletContext ctx = request.getServletContext();
		
		String fpath = "/resources/representativeImage/"+memberId;
		String path = ctx.getRealPath(fpath);
		
		
		File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdirs();
	    
	    
		
	    if(file[0].isEmpty())
	    	recipe.setRepresentativeImage(recipeImage.getRepresentativeImage());
	    if(!file[0].isEmpty()) {
			try {
				String fname = file[0].getOriginalFilename();  
				System.out.println("대표사진 이름 : "+fname);
				
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
				
				e.printStackTrace();
			}
		}
	    service.updateRecipe(recipe);
		
	    
	    service.deleteIngredient(recipeId);
	    
	    String[] array= ingredient.getFname().split(",");
		for(int i=0; i < array.length;i++) {
			System.out.println(i+"번째 재료는 ? =" +array[i]);
			
			ingredient.setFname(array[i]);
			ingredient.setRecipeId(recipeId);
			ingredient.setmemberId(memberId);
			
			System.out.println("ingredient 확인 : "+ingredient);
			service.insertingredient(ingredient);
			//service.update(ingredient); 버려
		}
	  //----------------------------------------------------------------
	  		
		List<FoodOrder> foodOrderImage = service.getFoodOrder(recipeId);
		System.out.println("foodOrderImage"+foodOrderImage);
		String[] temp = new String[200];
		System.out.println("기존에 있던 이미지 또는 null의 갯수 = "+foodOrderImage.size());
		for(int i=0;i<foodOrderImage.size();i++) {
			temp[i]=foodOrderImage.get(i).getImage();
			System.out.println("기존 이미지 이름 : "+temp[i]);
		}
/*		String[] temp = new String[foodOrderImage.size()];
		for(int i=0;i<foodOrderImage.size();i++) {
			temp[i]=foodOrderImage.get(i).getImage();
		}
*/		
		service.deleteFoodOrder(recipeId);
		
		String[] array2 = foodOrder.getContent().split(",");
		for(int i=0;i<array2.length;i++) {
			System.out.println("어레이  "+array2[i]);
		}
		
		System.out.println("array2의 갯수"+array2.length);
		for(int i=1;i<file.length;i++) {
	  			
	  			
	  			String fpath2 = "/resources/orderImage/"+memberId+"/"+i;
	  		    String path2 = ctx.getRealPath(fpath2);
	  		    
	  		    File filepath2 = new File(path2);
	  		    if(!filepath2.exists())
	  		    	filepath2.mkdirs();
	  			
	  			
	  			
	  		System.out.println("전체 file 갯수(새로운 것까지 추가됨) : " + file.length);
	  			
	  		
	  		
	  		if(foodOrderImage.size()+1>i) {
	  			
	  			
	  			if(!file[i].isEmpty()) {
	  				try {
	  					String fname = file[i].getOriginalFilename();  
	  					System.out.println("기존 이미지 이름입니다 : "+fname);
	  					System.out.println("i는 몇입니까?"+i);
	  					
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
	  			}else {
	  				System.out.println("바뀐게 없으니 기존의 이미지를 쓰겠습니다.");
	  				foodOrder.setImage(temp[i-1]);
	  			}
	  			
	  			
	  		}else {
	  			
	  			if(!file[i].isEmpty()) {
	  				try {
	  					String fname = file[i].getOriginalFilename();  
	  					System.out.println("새롭게 추가되는 이미지 이름입니다 : "+fname);
	  					System.out.println("i는 몇입니까?"+i);
	  					
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
	  			}else {
	  				foodOrder.setImage("null");
	  			}
	  		}
	  			
		  		foodOrder.setContent(array2[i-1]);
		  		foodOrder.setChapter(i);
		  		foodOrder.setRecipeId(recipeId);
		  		System.out.println("무엇이 인서트되는지 확인합시다 : "+foodOrder);
		  		service.insertFoodOrder(foodOrder);
	  			
	  			
	  		}
			
			
		
		 
		return "redirect:../"+recipeId;
	}
	
	//레시피 삭제하기--------------------------------------------------------------------------------
	
	
	@RequestMapping("{id}/delete")
	public String delete(@PathVariable("id") Integer recipeId) {

		service.deleteIngredient(recipeId);
		service.deleteFoodOrder(recipeId);
		service.deleteRecipe(recipeId);
		
		return "redirect:../list";
	}
	
	/*@GetMapping("{id}/delete")
	public String delete(FoodOrder foodOrder,
								Recipe recipe,
								Principal principal,
								Ingredient ingredient,
								@PathVariable("id") Integer recipeId){
									
		
		
		service.deleteIngredient(recipeId);
		service.deleteFoodOrder(recipeId);
		service.deleteRecipe(recipeId);
		
		return "chef.recipe.list";
		
	}*/
	
	
	
	
	
	
	
	
	
	
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
			
			System.out.println("여기서 이미 있냐?"+comment.getContent());
			
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
		
		System.out.println("recipe =reg= "+recipe);
		System.out.println("foodOrder =reg= "+foodOrder);
		System.out.println("ingredient =reg= "+ingredient);
		
		String memberId = principal.getName();
		System.out.println("당신의 로그인 아이디 = "+memberId);
		
		recipe.setMemberId(memberId);
		
		
		ServletContext ctx = request.getServletContext();
		
		String fpath = "/resources/representativeImage/"+memberId;
		String path = ctx.getRealPath(fpath);
		
		
		File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdirs();
	    
	    
	    
	    if(!file[0].isEmpty()) {
			try {
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
	  			}else {
	  				foodOrder.setImage("null");
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
