package com.yoribogo.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
		
		/*String memberId = member.getId();
		System.out.println("서비스" +memberId);
		memberRoleDao.insert(memberId);*/
		
		return result;
	}

	
	@Transactional
	public String getDefaultRoleByMemberId(String memberId) {
		
		String roleName = memberRoleDao.getDefaultRoleByMemberId(memberId);
		
		return roleName;
	}

	@Transactional
	public Member getMemberInfo(String memberId) {
		
		Member member = memberDao.get(memberId);
		
		return member;
	}

	//프로필 수정
	@Transactional
	public int updateProfile(Member member) {
		
		int result = memberDao.update(member);
		
		return result;
		
		
	}

	@Transactional
	public Member getMemberPwd(String memberId) {
		
		Member memberPwd = memberDao.getMemberPwd(memberId);
		
		return memberPwd;
	}

	@Transactional
	public Member getMember(String memberId) {
		
		Member member = memberDao.getMember(memberId);
		
		return member;
	}

	@Transactional
	public Member get(String memberId) {
		
		Member member = memberDao.get(memberId);
		
		return member;
	}

	@Transactional
	public List<Member> getMember() {
		
		List<Member> list = memberDao.getList();
		return list;
	}


	/*public Member getMemberId(Member id) {
		
		Member member = memberDao.getMemberId(id);
		
		return member;
	}*/

	



/*	@Transactional
	public int insertMemberRole(MemberRole memberRole) {
		
		int result = memberRoleDao.insert(memberRole);
		
		return result;
		
	}*/



}
