package com.yoribogo.controller.chef;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller("ChefRecipeController")
@RequestMapping("/chef/recipe/")
public class RecipeController {
	

	@RequestMapping("list")
	public String list(@RequestParam(value="p", defaultValue="1") Integer page, Model model) {

		return "chef.recipe.list";
	}
	


}
