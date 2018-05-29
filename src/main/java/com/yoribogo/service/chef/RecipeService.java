package com.yoribogo.service.chef;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

@Service("chefRecipeService")
public class RecipeService {
	
	@Autowired
	private RecipeDao recipeDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private IngredientDao ingredientDao;
	
	@Autowired
	private FoodOrderDao foodOrderDao;
	
	@Autowired
	private RecipeCommentDao recipeCommentDao;
	
	@Transactional
	public void insertRecipe(Recipe recipe) {
		recipeDao.insert(recipe);
	}
	
	@Transactional
	public void insertingredient(Ingredient ingredient) {
		ingredientDao.insert(ingredient);
		System.out.println("서비스 단 : " + ingredient);
	}
	
	@Transactional
	public void insertFoodOrder(FoodOrder foodOrder) {
		foodOrderDao.insert(foodOrder);
	}

	public List<Recipe> getRecipe() {
		
		List<Recipe> list = recipeDao.getList();
		return list;

		
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

	
	//댓글
	
	
	public List<RecipeComment> getRecipeCommentListByNote(Integer page, Integer recipeId) {
		
		List<RecipeComment> result = recipeCommentDao.getListByRecipe(page, recipeId);
		
		for(RecipeComment r : result)
			r.setRecipe(null);
		
		
		return result;
	}

	
	public int addComment(RecipeComment comment) {
		int result = recipeCommentDao.insert(comment);
		
		return result;
	}

	//view 에서 맴버 프로필 사진 가져오기
	@Transactional
	public Member getMember(String memberId) {
		
		Member member = memberDao.get(memberId);
		
		return member;
	}
	
}
