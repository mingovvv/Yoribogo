package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.RecipeLike;

public interface RecipeLikeDao {

	RecipeLike get(Integer recipeId, String memberId);

	int insert(RecipeLike recipeLike);

	int delete(RecipeLike recipeLike);

	//List에서 좋아요 
	List<RecipeLike> getList(String memberId);

	//좋아요 count
	int getLikeCount(Integer recipeId);

}
