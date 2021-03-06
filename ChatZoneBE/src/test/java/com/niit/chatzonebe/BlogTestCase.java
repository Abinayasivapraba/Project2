package com.niit.chatzonebe;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.chatzonebe.dao.BlogDAO;
import com.niit.chatzonebe.model.Blog;

public class BlogTestCase {

	@Autowired
	static AnnotationConfigApplicationContext context;
	
	@Autowired
	static Blog blog;
	
	@Autowired 
	static BlogDAO blogDAO;
	
	
	
	@BeforeClass
	public static  void init(){
		context=new  AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blog= (Blog) context.getBean("blog");
		blogDAO=(BlogDAO) context.getBean("blogDAO");
		
	}
	
	@Test
	public void updateBlogTestCase(){
		blog.setBlogid(12);
		//blog.setDatetime(2017-05-07 20:00:33.515);
		blog.setDescription("Spring MVC for web designing applications");
		blog.setId("user2");
		blog.setReason(" Present");
		blog.setTitle("Spring MVC");
		blog.setStatus('A');
		boolean flag =blogDAO.update(blog);
		//assertEquals("createBlogTestCase",true, flag);
		assertEquals("updateBlogTestCase",true, flag);
		
				
	}
	@Test
	public void createBlogTestCase(){
		blog.setBlogid(11);
		//blog.setDatetime(2017-05-07 20:00:33.515);
		blog.setDescription("Hibernate is an ORM to store the data in databasa");
		blog.setId("user1");
		blog.setReason("Data Present");
		blog.setTitle("Hibernate");
		blog.setStatus('A');
		boolean flag =blogDAO.save(blog);
		//assertEquals("createBlogTestCase",true, flag);
		assertEquals("createBlogTestCase",true, flag);
		
				
	}
	
		
		
		
		
	
	@Test
	public void updateBlog(){
		blog.setDescription("Spring MVC for web designing applications");
		blog.setId("user2");
		blog.setReason(" Data Present");
		blog.setTitle("Spring MVC");
		blog.setStatus('B');
		boolean flag=blogDAO.update(12);
		assertEquals("updateBlog",true, flag);
		
		
		
		
	}
	
 

}
