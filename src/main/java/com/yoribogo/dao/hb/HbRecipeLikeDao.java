package com.yoribogo.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.yoribogo.dao.RecipeLikeDao;
import com.yoribogo.entity.RecipeLike;

@Repository
public class HbRecipeLikeDao implements RecipeLikeDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public RecipeLike get(Integer recipeId, String memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		RecipeLike recipeLike = session.get(RecipeLike.class, new RecipeLike(recipeId, memberId));
		
		return recipeLike;
	}
	
	@Transactional
	@Override
	public int insert(RecipeLike recipeLike) {

		Session session = sessionFactory.getCurrentSession();		
		session.save(recipeLike);
		
		return 0;
		
	}

	@Transactional
	@Override
	public int delete(RecipeLike recipeLike) {
		
		Session session = sessionFactory.getCurrentSession();
		session.delete(recipeLike);
		
		return 0;
		
	}

}
