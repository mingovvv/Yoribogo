package com.yoribogo.dao;

import com.yoribogo.entity.RecipeLike;

public interface RecipeLikeDao {

	RecipeLike get(Integer recipeId, String memberId);

	int insert(RecipeLike recipeLike);

	int delete(RecipeLike recipeLike);

}
