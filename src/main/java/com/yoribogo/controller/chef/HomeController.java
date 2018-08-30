package com.yoribogo.controller.chef;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeLike;
import com.yoribogo.service.MemberService;
import com.yoribogo.service.chef.RecipeService;



@RequestMapping("/chef/")
@Controller("ChefHomeController") /*식별자 한쪽만 / 식별 가능하면 됨 / 노트 컨트롤러가 두개가 존재하기에 생기는 문제*/
public class HomeController {
	
	@Autowired
	private MemberService service;
	@Autowired
	private RecipeService Recipeservice;
	
	
	@GetMapping("index")//최신버전 get까지가능
	public String index(Integer page
								, Model model
								,Principal principal) {
		
		
		
		String memberId = principal.getName();
		
		List<Recipe> recipe = Recipeservice.getRecipe();
		model.addAttribute("recipe",recipe);
		
		System.out.println("recipe : "+recipe);
		
		List<RecipeLike> recipeLike = Recipeservice.getRecipeLike(memberId);
		model.addAttribute("recipeLike",recipeLike);
		
		System.out.println("recipeLike : "+recipeLike);
		
		model.addAttribute("checkDetail",1);
		
		return "chef.index";
	}
	
}