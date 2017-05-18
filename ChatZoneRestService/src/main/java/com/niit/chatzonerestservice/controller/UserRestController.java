package com.niit.chatzonerestservice.controller;

import java.util.List;

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

import com.niit.chatzonebe.dao.UserDAO;
import com.niit.chatzonebe.model.User;
@RestController 
public class UserRestController {
	@Autowired 
	private User user;
	@Autowired 
     private UserDAO userDAO;
	@Autowired
	private HttpSession session;
	
     
	
	private static final Logger log = LoggerFactory.getLogger(UserRestController.class);
	@GetMapping("/users")
        public ResponseEntity <List<User>> list()
    	 {
    		 List<User> userList=userDAO.list();
    		 return new ResponseEntity<List<User>>(userList,HttpStatus.OK);
    		 
    	 }
     @PostMapping("/addUser")
           public User addUser(@RequestBody User newUser) 
           {
    	      log.debug("Calling createUser");
    	      System.out.println("Calling createUser");
    	      user=userDAO.get(newUser.getId());
    	      if(user==null)
    	      {
    	    	  log.debug("User does not exists");
    	    	  System.out.println("Calling createUser not");
    	    	  userDAO.save(newUser);
    	    	  //user.setErrorcode("200");
    	    	  //user.setErrormessage("Thank you for Registration");
    	    	  
    	      }
    	      else
    	      {
    	    	  log.debug("choose another id as it is existed");
    	    	  user.setErrorcode("800");
    	    	  user.setErrormessage("choose another id");
    	      }
    	      log.debug("Ending of create user method");
    	      return newUser;
           }
     //@PostMapping()
    	      		
    	      
    	      
    	 
    	 
    	 
           

      
     
     
     @GetMapping("/validate/{id}/{password}")
     public User validateCredentials(@PathVariable("id") String id,@PathVariable("password") String password)
     {
    	 if(userDAO.ValidCredentials(id, password)==null)
    	 {
    		 user.setErrorcode("200");
    		 user.setErrormessage("User Found");
    	 }
    		 else
    		 {
    			 user.setErrorcode("404");
        		 user.setErrormessage("Invalid Credentials");
    			 
    		 }
    	 return null;
     }
     /*@PostMapping("/user")
     public User createUser(@RequestBody User user) {
     user=userDAO.get(user.getId());
     if(user==null)
     {
    	 userDAO.save(user);
     }
    	 else {
    		 user.setErrorcode("800");
    		 user.setErrormessage("This id exists,please choose another id");
    		 
    		}
     
     return user;
     }*/
     @PostMapping("/ValidateUserLogin")
 	public ResponseEntity<User> validateUserLogin(@RequestBody User newUser)
 	{
 		log.debug("Starting of the method UserLoginValidate");
 		newUser = userDAO.ValidCredentials(newUser.getId(), newUser.getPassword());
 		if(newUser==null)
 		{
 			newUser = new User();
 			newUser.setErrorcode("404");
 			newUser.setErrormessage("User Invalid");
 			log.debug("Starting of if method of UserLoginValidate");
 			log.debug("User is null, invalid credentials entered");
 			log.debug("Endinging of if method of UserLoginValidate");
 			return new ResponseEntity<User>(newUser,HttpStatus.OK);
 		}
 		else
 		{
 			newUser.setErrorcode("200");
 			newUser.setErrormessage("User Successfully Logged In");
 			log.debug("Starting of else method of UserLoginValidate");
 			log.debug("User is not null valid credentials entered");
 			log.debug("ending of else method of UserLoginValidate");
 			session.setAttribute("userLoggedIn", newUser.getId());
 			session.setAttribute("userLoggedInRole", newUser.getRole());
 			return new ResponseEntity<User>(newUser,HttpStatus.OK);
 		}
 	}
     
     
     


}
