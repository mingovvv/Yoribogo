package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.RecipeComment;

public interface RecipeCommentDao {

	List<RecipeComment> getListByRecipe(Integer page, Integer recipeId, String memberId);

	int insert(RecipeComment comment);

	List<RecipeComment> getListByRecipe(Integer id);




}
