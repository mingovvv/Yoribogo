package com.yoribogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yoribogo.dao.FoodOrderDao;
import com.yoribogo.dao.IngredientDao;
import com.yoribogo.dao.MemberDao;
import com.yoribogo.dao.RecipeCommentDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;



@Service("Refrigerator")
public class RefrigeratorService {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private IngredientDao ingredientDao;
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	@Autowired
	private RecipeCommentDao recipeCommentDao;
	
	@Autowired
	private MemberDao memberDao;

	@Transactional
	public List<Ingredient> getIngridient(String[] list) {
		
		List<Ingredient> ingredient = ingredientDao.getIngridient(list);
		
		return ingredient;
	}
	
	@Transactional
	public List<Recipe> getGenieRecipe(String[] list) {
		List<Recipe> genieRecipe = recipeDao.getGenieRecipe(list);
		return genieRecipe;
	}



}
