package com.yoribogo.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.IngredientDao;
import com.yoribogo.entity.Ingredient;
@Repository
public class HbIngredientDao implements IngredientDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public int insert(Ingredient ingredient) {
		
		Session session = sessionFactory.getCurrentSession();
		
		session.save(ingredient);
		
		int x =ingredient.getFname().length();
		
		System.out.println("하이버네이트 단 : "+ingredient);
		
		return 1;
	}

}
