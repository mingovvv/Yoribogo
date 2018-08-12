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
	      
		  System.out.println("댓글 실험 1 "+query); //org.hibernate.query.internal.QueryImpl@6ebb33fe
	      List<RecipeComment> list = query.getResultList();
	      System.out.println("댓글 실험 2 "+list);
	      
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
		
		int id = (int) session.save(comment); //세션에 저장된 코멘트의 갯수 // 최초의 갯수가 0개이므로 아이디를 등록할때 무조건 1이상이 됨
		System.out.println(id);
		int result = 0;
		if(id >0)
				result = 1;
		
		
		return result; //result값은 무조건 1이 반환
	}

	//댓글 수
	@Override
	public int getCommentCount(Integer recipeId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		int count = ((Long)session
				.createQuery("select count(*) from RecipeComment where recipeId=:recipeId")
				.setParameter("recipeId",recipeId)
				.uniqueResult()).intValue();
		
		return count;
	}

}
