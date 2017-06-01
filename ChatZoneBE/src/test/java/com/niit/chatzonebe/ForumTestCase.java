package com.niit.chatzonebe;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chatzonebe.dao.ForumDAO;
import com.niit.chatzonebe.model.Forum;

public class ForumTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Forum forum;
	
	@Autowired 
	static ForumDAO forumDAO;
	
	
	
	@BeforeClass
	public static  void init(){
		context=new  AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		forum= (Forum) context.getBean("forum");
		forumDAO=(ForumDAO) context.getBean("forumDAO");
		
	}
	
	/*@Test
	public void createForumTestCase(){
		
		forum.setForumid(102);;
		forum.setId("user1");
		forum.setForummessage("A Form to understand the concepts of Java");
		
		boolean flag =forumDAO.save(forum);
	    assertEquals("createForumTestCase",true, flag);
		
				
	}
	
	@Test
	public void updateForumTestCase(){
		
		forum.setForumid(102);
		forum.setId("user1");
		forum.setForummessage("A Form for concepts of Java");
		
		boolean flag =forumDAO.update(forum);
	    assertEquals("updateForumTestCase",true, flag);
		
				
	}
	*/@Test
	public void deleteForum(){
		
		boolean flag=forumDAO.delete(449874);
		assertEquals("deleteForum",true, flag);
	}
		
		
	
		
	}
	
 


