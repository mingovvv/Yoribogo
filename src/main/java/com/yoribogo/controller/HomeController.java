
package com.yoribogo.controller;

import java.awt.print.Pageable;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yoribogo.entity.Recipe;
import com.yoribogo.service.RecipeService;

@Controller
@RequestMapping("/")


public class HomeController {

	@Autowired
	private RecipeService service;
	
	@RequestMapping("index")
	public String index(Model model) {
		
		/*List<Recipe> recipe = service.getRecipePaging();
		model.addAttribute("recipe",recipe);*/
		List<Recipe> recipe = service.getRecipe();
		model.addAttribute("recipe",recipe);
	
		return "index";	
		 
	}
	
	@GetMapping("index/circle")
	@ResponseBody
	public String circle() {
		
		List<Recipe> recipe = service.getRecipe();
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
	

}