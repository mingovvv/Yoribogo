package com.yoribogo.dao;

import com.yoribogo.entity.CommunityComment;
import com.yoribogo.entity.CommunityContents;

public interface CommunityCommentDao {

	void getInsert(CommunityContents subContents);

	int insert(CommunityComment comment);

}
