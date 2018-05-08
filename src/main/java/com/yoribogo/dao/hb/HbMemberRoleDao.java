package com.yoribogo.dao.hb;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.yoribogo.entity.MemberRole;
import com.mysql.fabric.xmlrpc.base.Member;
import com.yoribogo.dao.MemberRoleDao;

@Repository
public class HbMemberRoleDao implements MemberRoleDao{

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public String getDefaultRoleByMemberId(String memberId) {

		Session session = sessionFactory.getCurrentSession();
		
		List<MemberRole> list = session.createQuery("from MemberRole mr where mr.defaultRole=0 or mr.defaultRole=1").getResultList();
		
		Iterator<MemberRole> iterator = list.iterator();
		int i = 0;
		String roleName = null;
		while(iterator.hasNext()) {
			//System.out.println(list.get(i).getMemberId());
			
			if(memberId.equals(list.get(i).getMemberId())) { 
				System.out.println(memberId+"  라는아이디를 사용중.");
				roleName = list.get(i).getRoleId();
				System.out.println(roleName+"  라는 권한이름을 가지고 있음.");
				break;
			}
		
			i++;
		}
		
		
		
		return roleName;
	}


	@Override
	public int insert(String memberId) {
		System.out.println("하이버" +memberId);
		
		
		Session session = sessionFactory.getCurrentSession();
		//System.out.println(session);
		MemberRole memberRole = new MemberRole();
		memberRole.setMemberId(memberId);
		session.save(memberRole);
		
		return 0;
	}




}
