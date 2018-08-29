package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityComment;
import com.yoribogo.entity.Recipe;

@Repository
public class HbCommunityDao implements CommunityDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public List<Community> getList() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Community> query = session.createQuery("from Community order by id desc", Community.class);
		List<Community> list = query.getResultList();
		
		return list;
	}

	@Transactional
	@Override
	public void getInsert(Community community) {
		Session session = sessionFactory.getCurrentSession();
		session.save(community);
		
	}
	
	@Transactional
	@Override
	public List<CommunityComment> getCommentList(Integer listId) {
		Session session = sessionFactory.getCurrentSession();
		
		Query<CommunityComment> query = session.createQuery("from CommunityComment where communityId=:listId", CommunityComment.class).setParameter("listId", listId);
		List<CommunityComment> list = query.getResultList();
		return list;
	}

}
