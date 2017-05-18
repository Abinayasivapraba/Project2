package com.niit.chatzonerestservice.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chatzonebe.dao.BlogDAO;
import com.niit.chatzonebe.model.Blog;

@RestController
public class BlogRestController {
	@Autowired
	private Blog blog;
	
	@Autowired
	private BlogDAO blogDAO;
	
	private static final Logger log = LoggerFactory.getLogger(BlogRestController.class);
	
	@GetMapping("/bloglist")
	
		public ResponseEntity<List<Blog>> list()
		{
		List<Blog> bloglist=blogDAO.list();
		return new ResponseEntity<List<Blog>>(bloglist,HttpStatus.OK);
			
			
		}
	/*@PostMapping("/blog")
	
		public ResponseEntity<Blog> createBlog(@RequestBody Blog blog,HttpSession session)
		{
		blog.setBlogid(ThreadLocalRandom.current().nextInt(100,1000000+1));
		String loggedInUserId=(String) session.getAttribute("loggedInUserId");
		log.debug("blog is created bybthe user"+loggedInUserId);
		blog.setId(loggedInUserId);
		blog.setStatus('N');
		long d = System.currentTimeMillis();
		Date today = new Date(d);
		blog.setDatetime(today);
		blogDAO.save(blog);
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);

	
	
	
	}*/
	@PostMapping("/blog/")
	
	public ResponseEntity<Blog> createBlog(@RequestBody Blog blog)
	{
		blog.setBlogid(ThreadLocalRandom.current().nextInt(100,1000000+1));
	//String loggedInUserId=(String) session.getAttribute("loggedInUserId");
	//log.debug("blog is created bybthe user"+loggedInUserId);
	//blog.setId(Id);
	//newBlog=new Blog();
		blog.setStatus('N');
		blog.setReason("Accept");
	long d = System.currentTimeMillis();
	Date today = new Date(d);
	blog.setDatetime(today);
	blogDAO.save(blog);
	return new ResponseEntity<Blog>(blog,HttpStatus.OK);




}
	

		
	
	
		
	}
	

