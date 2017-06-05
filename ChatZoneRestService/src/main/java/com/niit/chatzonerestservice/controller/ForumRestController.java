package com.niit.chatzonerestservice.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.chatzonebe.dao.ForumDAO;
import com.niit.chatzonebe.model.Forum;
@RestController
public class ForumRestController {
	
	@Autowired
	private Forum forum;;
	
	@Autowired
	private ForumDAO forumDAO;
	@Autowired
	private HttpSession session;
	
	private static final Logger log = LoggerFactory.getLogger(ForumRestController.class);
	
	@GetMapping("/forumlist")
	
		public ResponseEntity<List<Forum>> list()
		{
		List<Forum> forumlist=forumDAO.list();
		return new ResponseEntity<List<Forum>>(forumlist,HttpStatus.OK);
			
			
		}
	@PostMapping("/createforum/")
	public ResponseEntity<Forum> saveForum(@RequestBody Forum newForum)
	{
		log.debug("Starting of the method Create Forum");
		forum = forumDAO.getForumById(newForum.getForumid());
		String loggedInUserId = (String) session.getAttribute("userLoggedIn");
		if(loggedInUserId==null)
		{
			log.debug("Checking whether User Is Logged In Or Not");
			newForum.setErrorcode("400");
			newForum.setErrormessage("Login of User required..Please Login with your Id..");
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
		if(forum==null)
		{
			log.debug("Starting of null method method of saveForum");
			long d = System.currentTimeMillis();
			Date today = new Date(d);
			newForum.setForumid(ThreadLocalRandom.current().nextInt(100,1000000+1));
			//newForum.setForummessage("DevOps Concepts in detail");
			
			newForum.setDateadded(today);
			newForum.setId(loggedInUserId); //This is to be used when you start with front end
			 // This is for temporary purpose to make the rest service run
			forumDAO.save(newForum);
			newForum.setErrorcode("200");
			newForum.setErrormessage("Forum Successfully Posted Waiting To Be Approved By Admin");
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
		else
		{
			log.debug("Starting of else method of saveForum");
			newForum.setErrorcode("404");
			newForum.setErrormessage("Forum Does Not Posted Successfully Please Try Again");
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
	}
	
	
	
	@PostMapping("/ForumUpdate/")
	public ResponseEntity<Forum> updateForum(@RequestBody Forum newForum)
	{
		log.debug("Starting of method Update Forum");
		System.out.println(newForum.getForumid());
		forum = forumDAO.getForumById(newForum.getForumid());
		String loggedInUserId = (String) session.getAttribute("userLoggedIn");
		if(loggedInUserId==null)
		{
			log.debug("Checking whether User Is Logged In Or Not");
			newForum.setErrorcode("400");
			newForum.setErrormessage("User Not Logged In Please Log In First To Update Blog");
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
		if(forum==null)
		{
			log.debug("Starting of forum is null method of updateForum");
			newForum.setErrorcode("404");
			newForum.setErrormessage("No Such Blog Exists");
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
		else
		{
			if(forum.getId().equals(loggedInUserId))
			{
				log.debug("Starting of the method  update Blog");
				long d = System.currentTimeMillis();
				Date today = new Date(d);
				newForum.setDateadded(today);
				
				newForum.setId(forum.getId());
				if(newForum.getForummessage()==null || newForum.getForummessage()=="")
				{
					newForum.setForummessage(forum.getForummessage());
				}
				
				forumDAO.update(newForum);
				newForum.setErrorcode("200");
				newForum.setErrormessage("Forum Updated Successfully");
			}
			else
			{
				log.debug("Starting of else method of update Forum");
				newForum.setErrorcode("500");
				newForum.setErrormessage("You Cannot Update This Forum Because This Forum Is Created By Another User");
			}
			return new ResponseEntity<Forum>(newForum, HttpStatus.OK);
		}
	}
	
	@GetMapping("/removeForum/{forumid}")
	public String removeForum(@PathVariable("forumid") int forumid){
		log.debug("Start of method removeForum");
		boolean valid=forumDAO.delete(forumid);
		if(valid){
			log.debug("forum removed");
			return "Success";
		}
		else{
			log.debug("forum not removed");
			return "Error";
		}
	}
	
	@PostMapping("/ForumById/")
	public ResponseEntity<Forum> showForumByForumId(@RequestBody Forum forum)
	{
		log.debug("Starting of method showBlogById");
		forum = forumDAO.getForumById(forum.getForumid());
		if(forum==null)
		{
			log.debug("Checking whether Forum List is Null Or Not");
			forum = new Forum();
			forum.setErrorcode("404");
			forum.setErrormessage("No Such Forum Exists");
			return new ResponseEntity<Forum>(forum, HttpStatus.OK);
		}
		else
		{
			forum.setErrorcode("200");
			forum.setErrormessage("Blog By Id Fetched Successfully");
			return new ResponseEntity<Forum>(forum,HttpStatus.OK);
		}
	}
	
	

}
