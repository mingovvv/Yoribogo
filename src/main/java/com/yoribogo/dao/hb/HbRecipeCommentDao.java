package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.RecipeCommentDao;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;

@Repository
public class HbRecipeCommentDao implements RecipeCommentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<RecipeComment> getListByRecipe(Integer page, Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		
		  Query<RecipeComment> query 
	         = session
	            .createQuery("from RecipeComment where recipeId=:recipeId", RecipeComment.class)
	            .setParameter("recipeId", recipeId);
	      
	      List<RecipeComment> list = query.getResultList();
	      
	      
		return list;
	}
	
	
	@Transactional
	@Override
	public List<RecipeComment> getListByRecipe(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		 Query<RecipeComment> query 
         = session
            .createQuery("from RecipeComment where recipeId=:recipeId", RecipeComment.class)
            .setParameter("recipeId", recipeId);
      
      List<RecipeComment> list = query.getResultList();
      
      
	return list;
	}

	@Transactional
	@Override
	public int insert(RecipeComment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Recipe recipe = new Recipe();
		comment.setRecipe(recipe);
		
		int id = (int) session.save(comment);
		
		int result = 0;
		if(id >0)
				result = 1;
		
		
		return result;
	}

}
