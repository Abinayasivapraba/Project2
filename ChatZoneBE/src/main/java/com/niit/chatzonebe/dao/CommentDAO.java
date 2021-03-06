package com.niit.chatzonebe.dao;

import java.util.List;

import com.niit.chatzonebe.model.Comments;

public interface CommentDAO {
	public List<Comments> list(); 
	
	public Comments getCommentsById(int commentid);
	
	public List<Comments> getCommentsListByBlog(int blogid);
	
	public List<Comments> getCommentsListByForum(int forumid);
	
	public boolean save(Comments comments);
	
	public boolean update(Comments comments);
	
	public boolean delete(Comments comments);
	
	public Comments deleteCommentById(int commentid);
	
	
	
	

}
