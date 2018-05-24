package com.yoribogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Recipe;



@Service("RecipeService")
public class RecipeService {
	
	@Autowired
	private RecipeDao recipeDao;

	public List<Recipe> getRecipe() {
		
		List<Recipe> list = recipeDao.getList();
		return list;

		
	}

}
