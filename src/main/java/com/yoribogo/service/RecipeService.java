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
import com.yoribogo.dao.RecipeLikeDao;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;
import com.yoribogo.entity.RecipeLike;



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
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private RecipeLikeDao recipeLikeDao;

	public List<Recipe> getRecipe() {
		
		List<Recipe> list = recipeDao.getList();
		return list;

		
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


	public Member getMember(String memberId) {
		
		Member member = memberDao.get(memberId);
		
		return member;
	}


	@Transactional
	public List<RecipeLike> getRecipeLike(String memberId) {
		
		List<RecipeLike> list = recipeLikeDao.getList(memberId);
		
		return list;
	}


	@Transactional
	public List<Recipe> getLikeRecipe(String memberId) {
		
		List<Recipe> list = recipeDao.getLikeRecipe(memberId);
		return list;
	}


	@Transactional
	public int getReadCount(Integer recipeId) {

		int readCount = recipeDao.getReadCount(recipeId);
		
		return readCount;
		
	}  


	@Transactional
	public int getCommentCount(Integer recipeId) {
		
		int commentCount = recipeCommentDao.getCommentCount(recipeId);
		return commentCount;
	}


	@Transactional
	public int getLikeCount(Integer recipeId) {
		
		int likeCount = recipeLikeDao.getLikeCount(recipeId);
		
		return likeCount;
	}

	@Transactional
	public List<Recipe> listDate() {
		List<Recipe> list = recipeDao.listDate();
		return list;
	}


	@Transactional
	public List<Recipe> listPop() {
		List<Recipe> list = recipeDao.listPop();
		return list;
	}

 
	@Transactional
	public List<Recipe> listRan() {
		List<Recipe> list = recipeDao.listRan();
		return list;
	}

	@Transactional
	public List<Recipe> getRecipePaging() {
		List<Recipe> list = recipeDao.getRecipePaging();
		return list;
	}

}
