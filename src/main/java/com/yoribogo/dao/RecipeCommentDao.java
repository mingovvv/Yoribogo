package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.RecipeComment;

public interface RecipeCommentDao {

	List<RecipeComment> getListByRecipe(Integer page, Integer recipeId);

	int insert(RecipeComment comment);

	List<RecipeComment> getListByRecipe(Integer id);

	//댓글 수
	int getCommentCount(Integer recipeId);




}
