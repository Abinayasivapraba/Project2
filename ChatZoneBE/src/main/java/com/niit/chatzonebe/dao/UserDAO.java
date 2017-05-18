package com.niit.chatzonebe.dao;

import java.util.List;

import com.niit.chatzonebe.model.User;

public interface UserDAO {
	public User get(String id);
	
	public List<User> list();
	
	public User ValidCredentials(String id,String password);
	
	public boolean save(User user);
	
	public boolean update(User user);
	
	public boolean delete(User user);
	
	public boolean getUserById(String id);
	
	
	

}
