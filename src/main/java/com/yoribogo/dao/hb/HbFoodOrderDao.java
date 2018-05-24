package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.FoodOrderDao;
import com.yoribogo.entity.FoodOrder;
import com.yoribogo.entity.Ingredient;
@Repository
public class HbFoodOrderDao implements FoodOrderDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public int insert(FoodOrder foodOrder) {
		Session session = sessionFactory.getCurrentSession();
		
		session.save(foodOrder);
		
		
		System.out.println("푸드 오더 하이버네이트 단 : "+foodOrder);
		
		return 1;
	}

	@Transactional
	@Override
	public List<FoodOrder> get(Integer recipeId) {
		Session session = sessionFactory.getCurrentSession();
		Query<FoodOrder> query = session.createQuery("from FoodOrder where recipeId=:recipeId",FoodOrder.class)
				.setParameter("recipeId", recipeId);
		List<FoodOrder> foodOrders = query.getResultList();
		return foodOrders;
	}

}
