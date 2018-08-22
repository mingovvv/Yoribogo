package com.yoribogo.controller;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Recipe;
import com.yoribogo.service.RefrigeratorService;
import com.yoribogo.service.chef.RecipeService;

@Controller("genieController")
@RequestMapping("/refrigerator/")
public class RefrigeratorController {
	
	
	@Autowired
	private RefrigeratorService service;
	
	
	@GetMapping("genie")
	public String genie() {
		
		
		return "refrigerator.genie";
	}
	
	
	@GetMapping("genie/search")
	@ResponseBody
	public String ingreSearch(@RequestParam(value="list[]") String[] list){

		for(int i =0; i<list.length;i++) {
			System.out.println(list[i]);
		}
		
		
		List<Recipe> recipe = service.getGenieRecipe(list);
		
		Gson gson = new Gson();
		String json = gson.toJson(recipe);
		
		return json;
	}
}
