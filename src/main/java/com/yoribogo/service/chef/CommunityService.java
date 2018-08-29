package com.yoribogo.service.chef;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.CommunityCommentDao;
import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.MemberDao;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityComment;
import com.yoribogo.entity.CommunityContents;


@Service("ChefCommunityService")
public class CommunityService {

	@Autowired
	private CommunityDao communityDao;
	
	@Autowired
	private CommunityCommentDao commentDao;
	
	@Transactional
	public List<Community> getCommunity() {
		
		List<Community> list = communityDao.getList();
		
		return list;
	}
	
	@Transactional
	public void insertCommunity(Community community) {
		
		communityDao.getInsert(community);
		
	}
	
	@Transactional
	public List<CommunityComment> getComment(Integer listId) {
		
		List<CommunityComment>  commentList = communityDao.getCommentList(listId);
		
		return commentList;
	}

	public int addComment(CommunityComment comment) {
		int result = commentDao.insert(comment);
		
		return result;
	}

}
