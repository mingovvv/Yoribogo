package com.yoribogo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoribogo.dao.MemberDao;
import com.yoribogo.dao.MemberRoleDao;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberRoleDao memberRoleDao;
	
	@Transactional
	public int insertMember(Member member) {
		
		int result = memberDao.insert(member);
		
		String memberId = member.getId();
		memberRoleDao.insert(memberId);
		System.out.println("서비스" +memberId);
		
		
		return result;
	}

	
	@Transactional
	public String getDefaultRoleByMemberId(String memberId) {
		
		String roleName = memberRoleDao.getDefaultRoleByMemberId(memberId);
		
		return roleName;
	}



}
