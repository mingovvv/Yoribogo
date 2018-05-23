package com.yoribogo.dao.hb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.FoodOrderDao;
import com.yoribogo.entity.FoodOrder;
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

}
