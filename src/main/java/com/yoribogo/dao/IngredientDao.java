package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Ingredient;

public interface IngredientDao {

	int insert(Ingredient ingredient);

	List<Ingredient> get(Integer recipeId);

	//지니
	List<Ingredient> getIngridient(String[] list);
	

}
