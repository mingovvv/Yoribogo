package com.yoribogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.FoodOrderDao;
import com.yoribogo.dao.IngredientDao;
import com.yoribogo.dao.RecipeCommentDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;



@Service("RecipeService")
public class RecipeService {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private IngredientDao ingredientDao;
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	@Autowired
	private RecipeCommentDao recipeCommentDao;

	public List<Recipe> getRecipe() {
		
		List<Recipe> list = recipeDao.getList();
		return list;

		
	}

	public List<RecipeComment> getRecipeCommentListByNote(Integer page, Integer recipeId, String memberId) {
		
		List<RecipeComment> result = recipeCommentDao.getListByRecipe(page, recipeId, memberId);
		
		for(RecipeComment r : result)
			r.setRecipe(null);
		
		
		return result;
	}

	public int addComment(RecipeComment comment) {

		int result = recipeCommentDao.insert(comment);
		
		return result;
	}

	public Recipe getRecipe(Integer id) {

		Recipe recipe = recipeDao.get(id);
		List<RecipeComment> comments = recipeCommentDao.getListByRecipe(id);
		
		recipe.setComments(comments);
		
		return recipe;
	}

	public List<Ingredient> getIngridient(Integer recipeId) {
		List<Ingredient> ingredients = ingredientDao.get(recipeId);
		
		return ingredients;
	}

	public List<FoodOrder> getFoodOrder(Integer recipeId) {
		List<FoodOrder> foodOrders = foodOrderDao.get(recipeId);
		return foodOrders;
	}


}
