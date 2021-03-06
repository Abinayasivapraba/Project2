package com.niit.chatzonebe.dao.impl;

import java.util.List;




import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatzonebe.dao.BlogDAO;
import com.niit.chatzonebe.model.Blog;
@Repository("blogDAO")
@EnableTransactionManagement


public class BlogDAOImpl implements BlogDAO{
	
	
	private static final Logger log=LoggerFactory.getLogger(BlogDAOImpl.class);
	

	private SessionFactory sessionFactory;
	private Blog blog;
	
	public BlogDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Blog> list() {
		return sessionFactory.getCurrentSession().createQuery("from Blog").list();
		
	}
@Transactional
	public boolean save(Blog blog) {
		
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
@Transactional
	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
		} catch (HibernateException e) {
			
			e.printStackTrace();
		}
		return false;
	}
@Transactional

	public Blog get(int blogid) {
		Blog blog=(Blog) sessionFactory.getCurrentSession().get(Blog.class,blogid);
		
		return blog;
	}
@Transactional
public boolean delete(Blog blog) {
	try {
		sessionFactory.getCurrentSession().delete(blog);
	} catch (HibernateException e) {
		
		e.printStackTrace();
	}
		return false;
}
@Transactional
public boolean delete(int blogid) {
	try{
		sessionFactory.getCurrentSession().delete(getBlogById(blogid));
		return true;
	}
	catch(Exception e){
		System.err.println(e);
		return false;
	}
}
@Transactional
public boolean update(int blogid) {
	try {
		sessionFactory.getCurrentSession().update(getBlogById(blogid));
		return true;
	} catch (HibernateException e) {
		
		e.printStackTrace();
	}
	return false;
}
@Transactional
public Blog getBlogById(int blogid) {
	log.debug("Getting blog with blogId:"+blogid);
	
	return (Blog) sessionFactory.getCurrentSession().createQuery("from Blog where blogid ='"+ blogid +"'" ).uniqueResult();
}

}
