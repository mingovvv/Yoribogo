package com.yoribogo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.MemberDao;
import com.yoribogo.dao.MemberRoleDao;
import com.yoribogo.entity.Member;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		
		return result;
	}

	
	@Transactional
	public String getDefaultRoleByMemberId(String memberId) {
		
		String roleName = memberRoleDao.getDefaultRoleByMemberId(memberId);
		
		return roleName;
	}
}
