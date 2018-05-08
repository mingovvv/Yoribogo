package com.yoribogo.dao.hb;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import com.yoribogo.entity.MemberRole;
import com.yoribogo.entity.MemberRoleId;
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
		//-------------------------나중에 복합키에 대해 자세히 알게되면 구현-------------------
		/*while(iterator.hasNext()) {
			//System.out.println(list.get(i).getMemberId());
			
			if(memberId.equals(list.get(i).getMemberId())) { 
				System.out.println(memberId+"  라는아이디를 사용중.");
				roleName = list.get(i).getRoleId();
				System.out.println(roleName+"  라는 권한이름을 가지고 있음.");
				break;
			}
		
			i++;
		}*/
		//-------------------------나중에 복합키에 대해 자세히 알게되면 구현-------------------
		
		
		return roleName;
	}


	/*@Override
	public int insert(String memberId) {
		System.out.println("하이버" +memberId);
		
		
		Session session = sessionFactory.getCurrentSession();
		//MemberRole memberRole = new MemberRole();
		//MemberRoleId memberRoleId = new MemberRoleId(memberId, "ROLE_CHEF");
		
		//memberRole.setMemberId(memberRoleId);
		//memberRole.setMemberRoleId(memberRoleId);
		//memberRole.setMemberId("99");
		//memberRole.setRoleId("ROLE_CHEF");
		//memberRole.setDefaultRole(false);
		
		session.save(memberId);
		
		return 0;
	}*/


/*	@Override
	public int insert(MemberRole memberRole) {
		System.out.println("여기까지오나? : "+memberRole);
		Session session = sessionFactory.getCurrentSession();
		
		session.save(memberRole);
		
		
		return 1;
	}*/




}
