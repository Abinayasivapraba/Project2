package com.niit.chatzonebe.dao.impl;

import java.util.List;

//import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.chatzonebe.dao.UserDAO;
import com.niit.chatzonebe.model.User;

@Repository("userDAO")
@EnableTransactionManagement



public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	public UserDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	@Transactional
	public User get(String id) {
		User user=(User) sessionFactory.getCurrentSession().get(User.class,id);
		
		return user;
	}
	@Transactional
	public List<User> list() {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	/*public boolean isValidCredentials(String id, String password) {
		Query query=sessionFactory.getCurrentSession().createQuery("from User where id=? and password=?");
		query.setString(0, id);
		query.setString(1, password);
		if(query.uniqueResult()==null) {
			return false;
		}
		else {
			return true;
		}
		
	}*/
@Transactional
	public boolean save(User user) {
		
			try {
				sessionFactory.getCurrentSession().save(user);
				return true;
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return false;
			}
		
	}
@Transactional
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
			return true;
		} catch (HibernateException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	@Transactional
	public User ValidCredentials(String id, String password) {
		//return (User) sessionFactory.getCurrentSession().createQuery("from User where id='"+id+"' and password='"+password+"'").uniqueResult();
		Query query=sessionFactory.getCurrentSession().createQuery("from User where id=? and password=?");
		query.setString(0, id);
		query.setString(1, password);
	     List<User> list=(List<User>)query.list();
	     if(list !=null && !list.isEmpty()){
	    	 return list.get(0);
	     }
        return null;
		
	}

	public boolean getUserById(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*public boolean deleteUserById(String id) {
		try {
			sessionFactory.getCurrentSession().delete(deleteUserById(id));
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

		
	}*/
	
	
	

}
