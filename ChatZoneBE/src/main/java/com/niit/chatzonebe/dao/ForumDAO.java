package com.niit.chatzonebe.dao;

import java.util.List;

import com.niit.chatzonebe.model.Forum;

public interface ForumDAO {
public List<Forum> list();
	
	public boolean save(Forum forum);
	
	public boolean update(Forum forum);
	
	public Forum get(int forumid);
	
	public boolean delete(Forum forum);
	
	public Forum getForumById(int forumid);
	
	public boolean delete(int forumid);
	
	public boolean update(int forumid);
	

}
