package com.niit.chatzonebe.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatzonebe.dao.FriendDAO;
import com.niit.chatzonebe.model.Friend;

@Repository("friendDAO")
@EnableTransactionManagement
public class FriendDAOImpl implements FriendDAO{
private static final Logger log=LoggerFactory.getLogger(FriendDAOImpl.class);
	
	
	
	@Autowired
	private SessionFactory sessionFactory;
	public FriendDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public List<Friend> list() {
		return sessionFactory.getCurrentSession().createQuery("from Friend").list();
	}

	@Transactional
	public List<Friend> listFriendsByUserId(String id) {
		return sessionFactory.getCurrentSession().createQuery("from Friend where id='"+ id +"'").list();
	}
	@Transactional
	public List<Friend> listFriendsByFriendId(String friendid) {
		
		return sessionFactory.getCurrentSession().createQuery("from Friend where friendid='"+ friendid +"'").list();
	}
	@Transactional
	public Friend getFriendById(int fid) {
		return (Friend) sessionFactory.getCurrentSession().get(Friend.class, fid);
		
	}
	@Transactional
	public boolean save(Friend friend) {
		try {
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			}
		return false;
		
	}
	@Transactional
	public boolean delete(Friend friend) {
		try {
			sessionFactory.getCurrentSession().delete(friend);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			}
		return false;
		
	}

}
