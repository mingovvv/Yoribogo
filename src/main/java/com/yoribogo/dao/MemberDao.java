package com.yoribogo.dao;

import java.util.List;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;

public interface MemberDao {

	int insert(Member member);

	Member get(String memberId);

	//프로필 수정
	int update(Member member);

	Member getMemberPwd(String memberId);

	Member getMember(String memberId);

	List<Member> getList();

	/*Member getMemberId(Member id);*/





}
