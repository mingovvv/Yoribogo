package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.FoodOrder;

public interface FoodOrderDao {

	int insert(FoodOrder foodOrder);

	List<FoodOrder> get(Integer recipeId);

}
