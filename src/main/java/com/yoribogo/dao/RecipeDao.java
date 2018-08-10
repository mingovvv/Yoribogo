package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Recipe;

public interface RecipeDao {

	int insert(Recipe recipe);

	List<Recipe> getList();

	Recipe get(Integer id);

	//조회수 확인(디테일 페이지)
	int getReadCount(Integer recipeId);





}
