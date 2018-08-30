package com.yoribogo.controller;



import java.security.Principal;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.service.RecipeService;



@Controller("RecipeController")
@RequestMapping("/recipe/")
public class RecipeController {
	
	@Autowired
	private RecipeService service;

	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {
		
		List<Recipe> recipe = service.getRecipe();
		model.addAttribute("recipe",recipe);
		
		
		
		return "recipe.list";
	}
	
	

	//date 순 정렬
	@GetMapping("list/date")
	@ResponseBody
	public String listDate(){
		
		List<Recipe> recipe = service.listDate();
		
		
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
	
	//인기 순 정렬
	@GetMapping("list/pop")
	@ResponseBody
	public String listPop(){
		
		List<Recipe> recipe = service.listPop();
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
	
	//랜덤 정렬
	@GetMapping("list/ran")
	@ResponseBody
	public String listRan(){
		
		List<Recipe> recipe = service.listRan();
		
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
		
		Recipe recipe = service.getRecipe(id);
		model.addAttribute("recipe",recipe);
		
		//글쓴이 프로필 사진 가져오기
		Member memberf= service.getMember(recipe.getMemberId());
		model.addAttribute("memberf", memberf);
		
		List<Ingredient> ingredient = service.getIngridient(recipeId);
		model.addAttribute("ingredient",ingredient);
		
		List<FoodOrder> foodOrder = service.getFoodOrder(recipeId);
		model.addAttribute("foodOrder",foodOrder);
		
		//좋아요 숫자(디테일페이지) 
				int likeCount = service.getLikeCount(recipeId);
				model.addAttribute("likeCount",likeCount);
				
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
				 
				  int commentCount = service.getCommentCount(recipeId);
				  model.addAttribute("commentCount",commentCount);
		
		return "recipe.detail";
		
	}
}
