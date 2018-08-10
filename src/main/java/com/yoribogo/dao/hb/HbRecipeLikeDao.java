package com.yoribogo.dao.hb;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	//List(하트 / 빈하트)
	@Transactional
	@Override
	public List<RecipeLike> getList(String memberId) {
		
		Session session = sessionFactory.getCurrentSession();

		Query<RecipeLike> query 
			= session
				.createQuery("from RecipeLike where memberId=:memberId",RecipeLike.class)
				.setParameter("memberId", memberId); 
		
		
		
		
		System.out.println("빈하트 실험 1" + query);
		List<RecipeLike> list = query.getResultList();
		System.out.println("빈하트 실험 2" + list);
		
		return list;
	}

	//like count
	@Override
	public int getLikeCount(Integer recipeId) {

		Session session = sessionFactory.getCurrentSession();
		/*Query query =(Query) session
				.createQuery("select  count(*) from RecipeLike where recipeId=:recipeId",RecipeLike.class)
				.setParameter("recipeId", recipeId).uniqueResult();
		
		int likeCount = query.getFirstResult();*/
		
		//int likeCount = ((Integer)session
		//		.createQuery("select count(*) from RecipeLike where recipeId=:recipeId",RecipeLike.class)
		//		.setParameter("recipeId", recipeId).iterate().next()).intValue();
		
		/*RecipeLike likeCount = session
				.createQuery("select  count(*) from RecipeLike where recipeId=:recipeId",RecipeLike.class)
				.setParameter("recipeId", recipeId).uniqueResult();*/
		
		int count = ((Long)session
				.createQuery("select count(*) from RecipeLike where recipeId=:recipeId")
				.setParameter("recipeId",recipeId)
				.uniqueResult()).intValue();
		
		System.out.println("likeCount 실험 : "+count);
		return count;
	}

}
