package com.yoribogo.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.entity.MemberRole;
import com.yoribogo.dao.MemberRoleDao;

@Repository
public class HbMemberRoleDao implements MemberRoleDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public String getDefaultRoleByMemberId(String memberId) {

		Session session = sessionFactory.getCurrentSession();
		
		List<MemberRole> list = session.createQuery("from MemberRole mr where mr.defaultRole=1").getResultList();
		
		String roleName = list.get(1).getRoleId();
		
		return roleName;
	}

}
