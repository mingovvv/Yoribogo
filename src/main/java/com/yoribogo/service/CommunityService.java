package com.yoribogo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.MemberDao;
import com.yoribogo.entity.Community;


@Service("CommunityService")
public class CommunityService {

	@Autowired
	private CommunityDao communityDao;
	
	@Transactional
	public List<Community> getCommunity() {
		
		List<Community> list = communityDao.getList();
		
		return list;
	}

}
