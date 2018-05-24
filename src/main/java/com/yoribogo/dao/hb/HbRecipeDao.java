package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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

	@Transactional
	@Override
	public List<Recipe> getList() {

		Session session = sessionFactory.getCurrentSession();
		
		Query<Recipe> query = session.createQuery("from Recipe",Recipe.class); //임포트 하이버네이트 쿼리
		List<Recipe> list = query.getResultList();
		
		return list;
	}
	
	
	











	
}
