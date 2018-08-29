package com.yoribogo.dao.hb;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yoribogo.dao.CommunityCommentDao;
import com.yoribogo.dao.CommunityDao;
import com.yoribogo.dao.RecipeDao;
import com.yoribogo.entity.Community;
import com.yoribogo.entity.CommunityComment;
import com.yoribogo.entity.CommunityContents;
import com.yoribogo.entity.Recipe;
import com.yoribogo.entity.RecipeComment;

@Repository
public class HbCommunityCommentDao implements CommunityCommentDao{

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	@Override
	public void getInsert(CommunityContents subContents) {
		
		Session session = sessionFactory.getCurrentSession();
		session.save(subContents);
		
	}

	@Transactional
	@Override
	public int insert(CommunityComment comment) {
		
		Session session = sessionFactory.getCurrentSession();
		
		int id = (int) session.save(comment); //세션에 저장된 코멘트의 갯수 // 최초의 갯수가 0개이므로 아이디를 등록할때 무조건 1이상이 됨
		System.out.println(id);
		int result = 0;
		if(id >0)
				result = 1;
		
		return result;
	}




}
