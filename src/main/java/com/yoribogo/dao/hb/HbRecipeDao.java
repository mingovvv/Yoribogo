package com.yoribogo.dao.hb;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
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
	
	@Transactional
	@Override
	public Recipe get(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		
		Recipe recipe = session.get(Recipe.class, id);
		
		return recipe;
	}

	//조회수(디테일 페이지)
	@Override
	public int getReadCount(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("update Recipe set readCount = readCount +1 where id =:recipeId")
				.setParameter("recipeId", recipeId); 
		
		int readCount = query.executeUpdate();
		//업데이트가 되면 +1이 증가됨 int 변수 안에는 증가한 값 1이 들어감
		//1을 리턴하면 업데이트가 완료 된것.
		return readCount;
		
	}

	//mypage 내가 작성한 글
	@Override
	public List<Recipe> getList(String memberId) {

		Session session = sessionFactory.getCurrentSession();
		
		Query<Recipe> query = session.createQuery("from Recipe where memberId =:memberId",Recipe.class)
														.setParameter("memberId", memberId);
		
		List<Recipe> list = query.getResultList();
		
		return list;
	}

	//mypage 내가 좋아요 누른 레시피
	@Override
	public List<Recipe> getLikeRecipe(String memberId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Recipe> query = session.createQuery("from Recipe where id in (select recipeId from RecipeLike where memberId =:memberId)",Recipe.class)
				.setParameter("memberId", memberId);

		List<Recipe> list = query.getResultList();
		
		return list;
	}

	//recipe update
	@Override
	public void update(Recipe recipe) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(recipe);
		
	}
	

	@Override
	public void deleteIngredient(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("delete Ingredient where recipeId=:recipeId")
				.setParameter("recipeId", recipeId).executeUpdate();
		
	}

	@Override
	public void deleteFoodOrder(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("delete FoodOrder where recipeId=:recipeId")
				.setParameter("recipeId", recipeId).executeUpdate();
		
	}

	@Override
	public void deleteRecipe(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		
		session.createQuery("delete Recipe where id=:recipeId")
				.setParameter("recipeId", recipeId).executeUpdate();
		
	}

	@Override
	public List<Recipe> getGenieRecipe(String[] list) {
		
		Session session = sessionFactory.getCurrentSession();
		Query<Recipe> query = session.createQuery("from Recipe where id in (select recipeId from Ingredient where fname in (:list))",Recipe.class)
				.setParameterList("list", list);
		
		List<Recipe> genieRecipe = query.getResultList();
		System.out.println("실험 : "+genieRecipe);
		
		
		return genieRecipe;
	}
	
	
	











	
}
