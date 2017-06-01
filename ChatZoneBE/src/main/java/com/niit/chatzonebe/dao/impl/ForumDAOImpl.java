package com.niit.chatzonebe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatzonebe.dao.ForumDAO;
import com.niit.chatzonebe.model.Forum;

//import com.niit.chatzonebe.model.Forum;
@Repository("forumDAO")
@EnableTransactionManagement
public class ForumDAOImpl implements ForumDAO {
	private static final Logger log=LoggerFactory.getLogger(ForumDAOImpl.class);
	
	private SessionFactory sessionFactory;
	private Forum forum;
	
	public ForumDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Forum> list() {
		return sessionFactory.getCurrentSession().createQuery("from Forum").list();
		
	}
@Transactional
	public boolean save(Forum forum) {
		
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
@Transactional

	public Forum get(int forumid) {
		Forum forum=(Forum) sessionFactory.getCurrentSession().get(Forum.class,forumid);
		
		return forum;
	}
@Transactional
public boolean delete(Forum forum) {
	try {
		sessionFactory.getCurrentSession().delete(forum);
		return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
	}
		return false;
}
@Transactional
public boolean delete(int forumid) {
	try {
		sessionFactory.getCurrentSession().delete(getForumById(forumid));
		return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
	}
	return false;
}
@Transactional
public boolean update(int forumid) {
	try {
		sessionFactory.getCurrentSession().update(getForumById(forumid));
		return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
	}
	return false;
}
@Transactional
public Forum getForumById(int forumid) {
	log.debug("Getting forum with forumId:"+forumid);
	
	return (Forum) sessionFactory.getCurrentSession().createQuery("from Forum where forumid ='"+ forumid +"'" ).uniqueResult();
}


}
