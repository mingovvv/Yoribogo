package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Community;
import com.yoribogo.entity.FoodOrder;

public interface CommunityDao {
	
	List<Community> getList();

	void getInsert(Community community);

}
