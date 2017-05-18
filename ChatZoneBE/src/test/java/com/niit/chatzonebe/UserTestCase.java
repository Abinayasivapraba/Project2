package com.niit.chatzonebe;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chatzonebe.dao.UserDAO;
import com.niit.chatzonebe.model.User;

import junit.framework.Assert;

public class UserTestCase {
@Autowired  static AnnotationConfigApplicationContext context;
	
	@Autowired  static User user;
	
	@Autowired  static UserDAO  userDAO;
	
	
	
	@BeforeClass
	public static  void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		user = (User) context.getBean("user");
		
		userDAO = (UserDAO) context.getBean("userDAO");
		 
	}
	
	
	@Test
	
	public void validateCredentialsTestCase()
	{
		
	user =	  userDAO.ValidCredentials("user1", "user1");
	
	Assert.assertEquals("validateCredentialsTestCase", true );
	
		
	}
	
	
	
	@Test
	public void updateUserTestCase()
	{
		user.setId("manish");
		
		user.setName("manish");
		user.setPassword("manish");
		user.setRole("Student");
		user.setAddress("Andheri ");
		user.setEmail("manish@gmail.com");
		user.setContact("999999999");
	       boolean flag =	userDAO.save(user);
	       
	       assertEquals("updateUserTestCase ",true, flag);
	}
	
	@Test
	public void createUserTestCase()
	{
		user.setId("user4");
		user.setPassword("user4");
		
		user.setName("user4");
		user.setRole("Student");
		user.setAddress("Bangalore");
		user.setEmail("user4@gmail.com");
		user.setContact("8989395695");
	       boolean flag =	userDAO.save(user);
	       
	       assertEquals("createUserTestCase ",true, flag);
	}
	
	
	/*@Test
	public void getUserTestCase()
	{
		user =  userDAO.get("manish");
		
		assertEquals("getUserTestCase", null, user);
		
		
		
	}*/

	
	
	
	@Test
	public void list()
	{
		List<User> users=  userDAO.list();
		
		//select count(*) from c_user_detail
		assertEquals("getAllUsersTestCase",3,  users.size());
	}
	
	
	
	

	
}
