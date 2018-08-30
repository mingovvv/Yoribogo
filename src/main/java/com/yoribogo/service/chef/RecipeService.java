package com.yoribogo.service.chef;

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
	
	@Autowired
	private RecipeLikeDao recipeLikeDao;
	
	@Transactional
	public void insertRecipe(Recipe recipe) {
		recipeDao.insert(recipe);
	}
	
	@Transactional
	public void insertingredient(Ingredient ingredient) {
		ingredientDao.insert(ingredient);
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

	//좋아요
	public void setRecipeLike(Integer recipeId, String memberId) {
		
		RecipeLike recipeLike = recipeLikeDao.get(recipeId, memberId);
		
		if (recipeLike == null)
			recipeLikeDao.insert(new RecipeLike(recipeId, memberId));
		else
			recipeLikeDao.delete(recipeLike);
	}

	//리스트에서 좋아요 표시를 보기 위해
	@Transactional
	public List<RecipeLike> getRecipeLike(String memberId) {
		
		List<RecipeLike> list = recipeLikeDao.getList(memberId);
		
		return list;
	}
	
	//좋아요 갯수
	@Transactional
	public int getLikeCount(Integer recipeId) {
		
		int likeCount = recipeLikeDao.getLikeCount(recipeId);
		
		return likeCount;
	}
	
	//조회수
	@Transactional
	public int getReadCount(Integer recipeId) {

		int readCount = recipeDao.getReadCount(recipeId);
		
		return readCount;
		
	}

	//댓글수
	@Transactional
	public int getCommentCount(Integer recipeId) {
		
		int commentCount = recipeCommentDao.getCommentCount(recipeId);
		return commentCount;
	}
	
	//mypage 내가 작성한 레시피
	@Transactional
	public List<Recipe> getRecipe(String memberId) {
		
		List<Recipe> list = recipeDao.getList(memberId);
		
		return list;
	}

	//mypage 내가 좋아요 누른 레시피
	@Transactional
	public List<Recipe> getLikeRecipe(String memberId) {
		
		List<Recipe> list = recipeDao.getLikeRecipe(memberId);
		return list;
	}
	
	//recipe update
	
	@Transactional
	public void updateRecipe(Recipe recipe) {
		recipeDao.update(recipe);
		
	}
	
	@Transactional
	public void deleteIngredient(Integer recipeId) {
		recipeDao.deleteIngredient(recipeId);
	}
	
	@Transactional
	public void deleteFoodOrder(Integer recipeId) {
		recipeDao.deleteFoodOrder(recipeId);
		
	}
	@Transactional
	public void deleteRecipe(Integer recipeId) {
		recipeDao.deleteRecipe(recipeId);
		
	}
	
	@Transactional
	public List<Recipe> listDate(String memberId) {
		List<Recipe> list = recipeDao.listDate(memberId);
		return list;
	}
	
	@Transactional
	public List<Recipe> listPop(String memberId) {
		List<Recipe> list = recipeDao.listPop(memberId);
		return list;
	}

	@Transactional
	public List<Recipe> listRan(String memberId) {
		List<Recipe> list = recipeDao.listRan(memberId);
		return list;
	}

	
}
