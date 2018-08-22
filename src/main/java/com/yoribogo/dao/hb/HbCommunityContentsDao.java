package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.CommunityContentsDao;
import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityContents;
import com.yoribogo.entity.Recipe;

@Repository
public class HbCommunityContentsDao implements CommunityContentsDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void getInsert(CommunityContents subContents) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(subContents);
		
	}




}
