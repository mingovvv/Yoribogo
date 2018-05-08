package com.yoribogo.dao;

import com.mysql.fabric.xmlrpc.base.Member;
import com.yoribogo.entity.MemberRole;

public interface MemberRoleDao {

	String getDefaultRoleByMemberId(String memberId);

	int insert(String memberId);




}
