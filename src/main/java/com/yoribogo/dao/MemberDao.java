package com.yoribogo.dao;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;

public interface MemberDao {

	int insert(Member member);

	Member get(String memberId);

	//프로필 수정
	int update(Member member);

	/*Member getMemberId(Member id);*/





}
