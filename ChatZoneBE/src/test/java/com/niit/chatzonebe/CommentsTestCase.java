package com.niit.chatzonebe;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chatzonebe.dao.CommentDAO;
import com.niit.chatzonebe.model.Comments;
import static org.junit.Assert.*;

public class CommentsTestCase {
	
	
	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Comments comments;
	@Autowired
	static CommentDAO commentDAO;
	
	@BeforeClass
	public static  void init(){
		context=new  AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		comments= (Comments) context.getBean("comments");
		commentDAO=(CommentDAO) context.getBean("commentDAO");
		
	}
	@Test
	public void addCommentTestCase()
	{
		comments.setCommentid(13);
		comments.setBlogid(44983);
		comments.setForumid(96983);
		comments.setCommentsmsg("Hiiiii.........Welcome Everybody..");
		boolean flag=commentDAO.save(comments);
		assertEquals("addCommentTestCase",true,flag);
		
	}
	@Test
	public void updateCommentTestCase()
	{
		comments.setCommentid(11);
		comments.setBlogid(44987);
		comments.setForumid(96987);
		comments.setCommentsmsg("Hiiiii.........Welcome Everyone..Enjoy the day..");
		boolean flag=commentDAO.update(comments);
		assertEquals("updateCommentTestCase",true,flag);
		
	}
	
	

	
}
