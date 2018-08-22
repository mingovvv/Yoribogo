package com.yoribogo.service.chef;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.CommunityContentsDao;
import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.MemberDao;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityContents;


@Service("ChefCommunityService")
public class CommunityService {

	@Autowired
	private CommunityDao communityDao;
	
	@Autowired
	private CommunityContentsDao contentDao;
	
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
	public void insertSubContents(CommunityContents subContents) {
		
		contentDao.getInsert(subContents);
		
	}

}
