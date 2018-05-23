package com.yoribogo.controller.chef;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.service.chef.RecipeService;

@Controller("ChefRecipeController")
@RequestMapping("/chef/recipe/")
public class RecipeController {
	
	@Autowired
	private RecipeService service;
	
	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {

		return "chef.recipe.list";
	}
	

	@GetMapping("reg")
	public String reg() {

		return "chef.recipe.reg";
	}
	
	@PostMapping("reg")
	public String reg(FoodOrder foodOrder, MultipartFile file[], Recipe recipe, Principal principal, Ingredient ingredient, HttpServletRequest request) {
		
		
		String memberId = principal.getName();
		
		System.out.println(memberId);
		recipe.setMemberId(memberId);
		
		
		service.insertRecipe(recipe);
		System.out.println(recipe);
		
		String[] array= ingredient.getFname().split(",");
		for(int i=0; i < array.length;i++) {
			System.out.println(i+"번째 재료는 ? =" +array[i]);
			
			ingredient.setFname(array[i]);
			int recipeId=recipe.getId();
			ingredient.setRecipeId(recipeId);
			ingredient.setmemberId(memberId);
			service.insertingredient(ingredient);
		}
		
		
		
		
		
		
		
		System.out.println("file은 = "+file);
		
		
		ServletContext ctx = request.getServletContext();
		System.out.println(ctx);
		
		String fpath = "/resources/representativeImage/"+memberId+"/"+recipe.getId();
		String path = ctx.getRealPath(fpath);
		
		String fpath2 = "/resources/orderImage/"+memberId+"/"+recipe.getId()+"/"+foodOrder.getChapter();
		String path2 = ctx.getRealPath(fpath2);
		
		File filepath = new File(path);
	    if(!filepath.exists())
	    	filepath.mkdirs();
	    
	    File filepath2 = new File(path2);
	    if(!filepath2.exists())
	    	filepath2.mkdirs();
	    
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	    
	  //----------------------------------------------------------------

		
	  		String[] array2 = foodOrder.getContent().split(",");
	  		for(int i=0; i < array2.length;i++) {
	  			System.out.println(i+"번째 내용은 ? =" +array2[i]);
	  		int recipeId=recipe.getId();
	  		foodOrder.setContent(array2[i]);
	  		foodOrder.setChapter(i+1);
	  		foodOrder.setRecipeId(recipeId);
	  		service.insertFoodOrder(foodOrder);
	  		}
	  		
	  		
	  		for(int i=1;i<file.length;i++) {
	  			if(!file[i].isEmpty()) {
	  				try {
	  					String fname = file[i].getOriginalFilename();  
	  					System.out.println(fname);
	  					
	  					foodOrder.setImage(fpath+'/'+fname);
	  					
	  					InputStream fis = file[i].getInputStream();
	  					
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
	  		}
	  		
	  		//----------------------------------------------------------------
		
		return "redirect:list";
		
	}

}
