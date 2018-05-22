package com.yoribogo.controller.chef;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoribogo.entity.Ingredient;
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
	public String reg(Recipe recipe, Principal principal, Ingredient ingredient) {
		
		String memberId = principal.getName();
		System.out.println(memberId);
		recipe.setMemberId(memberId);
		recipe.setRepresentativeImage("z");
		
		
		service.insertRecipe(recipe);
		System.out.println(recipe);
		
		int recipeId=recipe.getId();
		ingredient.setRecipeId(recipeId);
		System.out.println("레시피id : " +recipeId);
		
		service.insertingredient(ingredient);
		
		
		return "redirect:list";
		
	}

}
