package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Recipe;

public interface RecipeDao {

	int insert(Recipe recipe);

	List<Recipe> getList();

	Recipe get(Integer id);





}
