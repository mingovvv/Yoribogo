package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.MemberDao;
import com.yoribogo.entity.Ingredient;
import com.yoribogo.entity.Member;

@Repository
public class HbMemberDao implements MemberDao{

	@Autowired
	private SessionFactory sessionFactory;
	

	
	@Override
	public int insert(Member member) {

		Session session = sessionFactory.getCurrentSession();
		
		session.save(member);
		
		System.out.println(member);
		
		return 1;
	}


	@Transactional
	@Override
	public Member get(String id) {

		Session session = sessionFactory.getCurrentSession();
		
		Member member = session.get(Member.class, id);
		
		return member;
	}

	/*@Transactional
	@Override
	public Member getMemberId(Member id) {
		
		Session session = sessionFactory.getCurrentSession();
		 
		Query<Member> query = session.createQuery("from member where id=:id", Member.class).setParameter("id", id);
		
		List<Member> list = query.getResultList();
		
		return (Member) list;
	}*/













	
}
