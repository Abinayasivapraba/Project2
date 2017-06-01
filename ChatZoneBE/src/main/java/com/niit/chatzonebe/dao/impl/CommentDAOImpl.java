package com.niit.chatzonebe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatzonebe.dao.CommentDAO;
import com.niit.chatzonebe.model.Comments;

@Repository("commentDAO")
@EnableTransactionManagement

public class CommentDAOImpl implements CommentDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public CommentDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
@Transactional
	public List<Comments> list() {
		return sessionFactory.getCurrentSession().createQuery("from Comments").list();
		
	}
@Transactional
	public Comments getCommentsById(int commentid) {
		return (Comments) sessionFactory.getCurrentSession().get(Comments.class, commentid);
		
	}
@Transactional

	public List<Comments> getCommentsListByBlog(int blogid) {
		return sessionFactory.getCurrentSession().createQuery("from Comments where blogid ='"+ blogid +"'").list();
	}
@Transactional

	public List<Comments> getCommentsListByForum(int forumid) {
		return sessionFactory.getCurrentSession().createQuery("from Comments where forumid ='"+ forumid +"'").list();
	}
@Transactional
	public boolean save(Comments comments) {
		try {
			sessionFactory.getCurrentSession().save(comments);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Comments comments) {
		try {
			sessionFactory.getCurrentSession().update(comments);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean delete(Comments comments) {
		try {
			sessionFactory.getCurrentSession().delete(comments);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}

public Comments deleteCommentById(int commentid) {
	return null;
}

	}
