package com.yoribogo.controller.chef;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String reg(Recipe recipe, Principal principal) {
		
		String memberId = principal.getName();
		System.out.println(memberId);
		
		recipe.setRepresentativeImage("z");
		
		recipe.setMemberId(memberId);
		System.out.println(recipe);
		service.insertRecipe(recipe);
		
		return "redirect:list";
		
	}

}
