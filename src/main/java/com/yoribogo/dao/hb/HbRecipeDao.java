package com.yoribogo.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.MemberDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Member;
import com.yoribogo.entity.Recipe;

@Repository
public class HbRecipeDao implements RecipeDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int insert(Recipe recipe) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(recipe);
		
		return 1;
	}
	











	
}
