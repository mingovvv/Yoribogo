package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Recipe;

public interface RecipeDao {

	int insert(Recipe recipe);

	List<Recipe> getList();

	Recipe get(Integer id);

	//조회수 확인(디테일 페이지)
	int getReadCount(Integer recipeId);

	//mypage 내가 작성한 레시피
	List<Recipe> getList(String memberId);

	//mypage 내가 좋아요 누른 레시피
	List<Recipe> getLikeRecipe(String memberId);





}
