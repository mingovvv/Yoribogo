package com.yoribogo.service.chef;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.IngredientDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Recipe;

@Service("chefRecipeService")
public class RecipeService {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private IngredientDao ingredientDao;
	
	@Transactional
	public void insertRecipe(Recipe recipe) {
		recipeDao.insert(recipe);
	}
	
	@Transactional
	public void insertingredient(Ingredient ingredient) {
		ingredientDao.insert(ingredient);
		System.out.println("서비스 단 : " + ingredient);
	}
	
}
