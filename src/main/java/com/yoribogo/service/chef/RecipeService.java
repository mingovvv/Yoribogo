package com.yoribogo.service.chef;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Recipe;

@Service("chefRecipeService")
public class RecipeService {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Transactional
	public void insertRecipe(Recipe recipe) {
		recipeDao.insert(recipe);
	}
	
}
