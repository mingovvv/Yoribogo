package com.yoribogo.dao;

import com.yoribogo.entity.Member;
import com.yoribogo.entity.MemberRole;

public interface MemberDao {

	int insert(Member member);

	Member get(String memberId);




}
