package com.yoribogo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysql.fabric.xmlrpc.base.Member;
import com.yoribogo.dao.MemberDao;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao memberDao;
	
	public int insertMember(Member member) {
		
		memberDao.insert(member);
		return 0;
	}

}
